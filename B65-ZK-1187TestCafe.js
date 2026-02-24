import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1187TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1187TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
1. Please click the button, and then the style of the tab is the same as selected.
<button  label="Click Me" onClick=\'tab.sclass="def"\'/>
	<tabbox width="250px">
		<tabs>
			<tab id="tab" label="Tab 1" sclass="abc" closable="true"/>
		</tabs>
		<tabpanels>
			<tabpanel>This is panel 1</tabpanel>
		</tabpanels>
	</tabbox>
</zk>`,
	);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq("@tab.def")[0])())
		.ok("the style of the tab is the same as selected");
});
