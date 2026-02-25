import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-2922762TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-2922762TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
					The tabbox below doesn\'t show tabscroll.(Doesn\'t have left and right arrow button on the tabbox is correct )
					<separator height="30px"/>
					<tabbox width="150px" tabscroll="false">
						<tabs>
							<tab id="tab1" label="Tab 1" closable="true"/>
							<tab label="Tab 2" closable="true"/>
							<tab label="Tab 3" closable="true"/>
							<tab label="Tab 4" closable="true"/>
							<tab label="Tab 5" closable="true"/>
						</tabs>
						<tabpanels id="tabpnl">
							<tabpanel>This is panel 1</tabpanel>
							<tabpanel>This is panel 2</tabpanel>
							<tabpanel>This is panel 3</tabpanel>
							<tabpanel>This is panel 4</tabpanel>
							<tabpanel>This is panel 5</tabpanel>
						</tabpanels>
					</tabbox>
				</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-tabs-left-scroll")[0])())
		.notOk();
	await t
		.expect(await ClientFunction(() => !!jq(".z-tabs-right-scroll")[0])())
		.notOk();
});
