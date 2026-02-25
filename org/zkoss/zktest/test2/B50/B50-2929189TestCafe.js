import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2929189TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2929189TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>

1.Click this <button label="Show Tabbox">
<attribute name="onClick">
mydiv.setVisible(true);
</attribute>
</button>
, after click, it should display a tabbox below, if there is no tabbox, it\'s wrong
<separator height="20px"/>
<div id="mydiv" width="200px" height="200px" visible="false">
<tabbox tabscroll="false">
	<tabs>
		<tab label="tab1" />
		<tab label="tab2" />
	</tabs>
	<tabpanels>
		<tabpanel>tabpanel1</tabpanel>
		<tabpanel>tabpanel2</tabpanel>
	</tabpanels>
</tabbox>
</div>
</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-tabbox")[0])()).ok();
});
