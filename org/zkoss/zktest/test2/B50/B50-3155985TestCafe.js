import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3155985TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3155985TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<zscript><![CDATA[
long begin = 0;
class MyComposer extends org.zkoss.zk.ui.util.GenericForwardComposer {
	public void onClick$btn() {
		timer.stop();
		timer.start();
		begin = System.currentTimeMillis();
		inf.appendChild(new Label("timer started"));
	}
	public void onTimer$timer() {
		inf.appendChild(new Label("timer fired: " + (System.currentTimeMillis() - begin) /1000));
	}
}
]]></zscript>
<div apply="MyComposer">
<html><![CDATA[
	<ol>
	<li>Click the Fire button</li>
	<li>Then, "timer started" apears, and after 3 seconds, "timer fired: 3" appears</li>
	</ol>
]]></html>

<timer id="timer" running="false" repeats="false" delay="3000" />
<button id="btn" label="Fire"/>
<vlayout id="inf"/>
</div>
</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("btn", true).$n()));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@label:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("timer started"));
	await t.wait(2000);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@label:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	await t.wait(1500);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@label:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("timer fired:"), "");
});
