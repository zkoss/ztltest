import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1821TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1821TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk xmlns:n="native" xmlns:w="client">
	<label multiline="true">
	1. Click "Select Tab2" button.
	2. Mouse over on red part, should not see JS Error showed.
	</label>
	<button id="tab2btn" label="Select Tab2">
		<attribute name="onClick">
			tabbox.setSelectedTab(tab2);
			tabbox.invalidate();
		</attribute>
	</button>
	<tabbox id="tabbox">
		<tabs id="tabs">
			<tab id="tab1" label="Tab 1"></tab>
			<tab id="tab2" label="Tab 2"></tab>
		</tabs>
		<tabpanels id="tabpanels">
			<tabpanel>Test</tabpanel>
			<tabpanel>
				<n:div>
					<div style="background:red;padding: 10px;">
						<attribute w:name="doMouseOver_"><![CDATA[
							function (evt) {
								if (!this.desktop) {
									zk.error(\'bind failed\');
								}
							}
						]]></attribute>
						<window title="window inside native" vflex="true" hflex="false">
						</window>
					</div>
				</n:div>
			</tabpanel>
		</tabpanels>
	</tabbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(Tab)")[0]));
	await ztl.waitResponse(t);
	await t.hover(
		Selector(() => zk.Widget.$(jq(".z-window-embedded")).$n("cap")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});
