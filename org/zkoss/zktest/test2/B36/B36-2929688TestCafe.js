import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2929688TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2929688TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window>
	<tabbox mold="accordion-lite">
	<tabs>
		<tab id="tab1" label="Tab 1"/>
		<tab id="tab2" label="Tab 2"/>
	</tabs>
	<tabpanels>
		<tabpanel>
		<label value="Test"/>
		</tabpanel>
		<tabpanel>
		<textbox id="tb" constraint="no empty"/> 
		</tabpanel> 
	</tabpanels> 
	</tabbox> 
	<button label="Check Me, then you should see a WrongValue exception!" onClick="click()"/> 
	<zscript> void click() { 
		try{ tb.getValue(); }
		catch(WrongValueException e)
		{ tab2.setSelected(true); throw e; } }
	</zscript> 
</window>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
});
