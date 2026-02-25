import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2031TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2031TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window border="normal" title="Button\'s image" width="300px">
	<label multiline="true">
		1. click the checkbox.
		2. The button\'s image should show up.
	</label>
	<separator/>
	<checkbox id="acceptTermBox" onCheck="setImage()"/>
	<space/>
	<button id="btn" label="Button" />
	<zscript><![CDATA[
		public void setImage(){
			if (acceptTermBox.isChecked()){
				btn.setImage("/img/battery.gif");
			} else {
				btn.setImage("");
			}
		}
	]]></zscript>
</window>`,
	);
	await t.click(Selector(() => jq(".z-checkbox input")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-button-image")[0])())
		.ok("The button's image should show up.");
});
