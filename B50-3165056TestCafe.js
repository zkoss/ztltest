import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3165056TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3165056TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Open the bandbox.</li>
			<li>type some text in the textbox.</li>
			<li>click the button.</li>
			<li>The text shall be show in the model window.</li>
		</ol>
	]]></html>
	<bandbox id="bb">
		<bandpopup>
			Textbox: <textbox id="tb" />
		</bandpopup>
	</bandbox>
	<button label="show values" onClick=\'alert(tb.value)\' />
</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("bb", true).$n("btn")));
	await ztl.waitResponse(t);
	await t.typeText(
		Selector(() => zk.Desktop._dt.$f("tb", true).$n()),
		ztl.normalizeText("xxx"),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq('@window[title="ZK Test"] @label')
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("xxx"));
});
