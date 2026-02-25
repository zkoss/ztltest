import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2057TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2057TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="checkbox setChecked" contentType="text/html;charset=UTF-8"?>
<zk>
	<label multiline="true">
		1. Click \'checked\',then the checkbox will be checked;
		2. Click \'unChecked\',then the checkbox will be unchecked;
		3  Click \'checked\',then the checkbox will be checked;
	</label>
	<window title="checkbox setChecked" border="normal">
		<checkbox id="testBox"></checkbox>
		<button label="checked" id="trueBtn" onClick="checkTrueClick()"/>
		<button label="unChecked" id="fasleBtn" onClick="checkFalseClick()"/>
		<zscript><![CDATA[
			void checkTrueClick() {
				testBox.setChecked(true);
			}
			void checkFalseClick() {
				testBox.setChecked(false);
			}
		]]></zscript>
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(checked)")[0]));
	await ztl.waitResponse(t);
	await t.expect("false").ok("the checkbox will be checked");
	await t.click(Selector(() => jq(".z-button:contains(unChecked)")[0]));
	await ztl.waitResponse(t);
	await t.expect("true").ok("the checkbox will be unchecked");
	await t.click(Selector(() => jq(".z-button:contains(checked)")[0]));
	await ztl.waitResponse(t);
	await t.expect("false").ok("the checkbox will be checked");
});
