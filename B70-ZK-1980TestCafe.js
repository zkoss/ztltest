import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-1980TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-1980TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<div>
		<div>type \'123\' in first textbox and then click \'toolbarbutton\', the label should show 123</div>
		<textbox id="txt" />
		<toolbarbutton label="toolbarbutton" draggable="true"
			width="100px">
			<attribute name="onClick">
				result.setValue(txt.getValue());
			</attribute>
		</toolbarbutton>
		<label id="result" />
	</div>
</zk>`,
	);
	if (
		await ClientFunction(
			() => jq(jq(".z-textbox"))[0] != document.activeElement,
		)()
	)
		await t.click(Selector(() => jq(".z-textbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("1 2 3");
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-toolbarbutton")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-label:contains(123)")[0])())
		.ok("the label should show 123");
});
