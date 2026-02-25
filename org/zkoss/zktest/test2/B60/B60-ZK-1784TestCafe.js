import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-1784TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1784TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk xmlns:n="native">
	Click the button, no JS should appear: tabbox will be invalidated, the component nested in native element in Tab1 should not cause a problem
	<tabbox id="tabbox" apply="org.zkoss.zktest.test2.B60_ZK_1784_Composer">
		<tabs id="tabs">
			<tab id="tab1" label="Tab 1" />
			<tab id="tab2" label="Tab 2" selected="true" />
		</tabs>
		<tabpanels id="tabpanels">
			<tabpanel>
				<n:div>
					<div hflex="0">
						Test inside native
					</div>
				</n:div>
			</tabpanel>
			<tabpanel>
				<button id="button" label="click me">
				</button>
			</tabpanel>
		</tabpanels>
	</tabbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
	await t.click(Selector(() => jq(".z-tab:contains(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});
