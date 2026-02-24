import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3081315TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3081315TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html>
		<![CDATA[
			<ol>
			<li>Click close button in tab1, a confirm dialog will appear.</li>
			<li>Click no</li>
			<li>the tab1 shall be selected</li>
			</ol>
		]]>
	</html>
	<zscript><![CDATA[
		public void doClose(Event event) {
			Tab tab = (Tab) event.getTarget();
			Messagebox.show("Delete?", "Prompt", Messagebox.YES | Messagebox.NO,
					Messagebox.QUESTION, new EventListener() {
						public void onEvent(Event evt) {
							if (Messagebox.YES == ((Integer) evt.getData())
									) {
								tab.close();
							}
						}
					});
			event.stopPropagation();
		}
	]]></zscript>
	<tabbox>
		<tabs>
			<tab label="tab1" closable="true" onClose="doClose(event);" />
			<tab label="tab2" closable="true" onClose="doClose(event);" />
			<tab label="tab3" closable="true" onClose="doClose(event);" />
		</tabs>
		<tabpanels>
			<tabpanel>Tab1</tabpanel>
			<tabpanel>Tab2</tabpanel>
			<tabpanel>Tab3</tabpanel>
		</tabpanels>
	</tabbox>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-tab").length)(),
			),
		)
		.eql(ztl.normalizeText("3"));
	await t.click(Selector(() => zk.Widget.$(jq(".z-tab:eq(1)")).$n("cls")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-tab").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
	await t.click(Selector(() => zk.Widget.$(jq(".z-tab:eq(0)")).$n("cls")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:eq(1)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-tab").length)(),
			),
		)
		.eql(ztl.normalizeText("2"));
});
