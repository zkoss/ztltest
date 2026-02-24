import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2148TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2148TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<label multiline="true">
		1. Select "option 1" in the selectbox. 
		2. Click "clear" button.
		3. Open and close the selectbox should not see NullPotinerException showed.
	</label>
	<div>
		<selectbox id="selbox"
			onSelect=\'System.out.println(self.getSelectedIndex())\' />
		<button id="btn" label="clear" onClick="clear()" />
		<zscript><![CDATA[
	ListModelList lml = new ListModelList();
	lml.add("option 1");
	lml.add("option 2");
	lml.add("option 3");
	lml.add("option 4");
	lml.add("option 5");
	selbox.setModel(lml);
	void clear() {
		selbox.setModel(null);
	}
]]></zscript>
	</div>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-selectbox")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-selectbox").find("option:contains(1)")[0]),
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-selectbox")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("should not see NullPotinerException showed.");
	await t.click(Selector(() => jq(".z-selectbox")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("should not see NullPotinerException showed.");
});
