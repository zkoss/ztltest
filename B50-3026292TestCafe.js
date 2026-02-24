import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3026292TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3026292TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
<html>
<![CDATA[
<ol>
	<li>Click the button</li>
	<li>Check the label, it shall in the bandpopup of the bandbox</li>
</ol>
]]>
</html>
	<zscript><![CDATA[
		void addPop(){
			Bandpopup bandpopup = new Bandpopup();
			bandpopup.setParent(bandbox);
			bandpopup.appendChild(new Label("label"));
		}
	]]></zscript>
	<bandbox id="bandbox"/>
	<button id="b" label="add bandpopup" onClick="addPop()"/>
</zk>`,
	);
	await t.click(Selector(() => zk.Desktop._dt.$f("b", true).$n()));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Desktop._dt.$f("bandbox", true).$n("btn")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(zk.Widget.$(jq(".z-bandbox")).$n("pp"))
						.find(".z-label")
						.text()
						.replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("label"));
});
