import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3190987TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3190987TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Click "add" button.</li>
			<li>The content of the tabbox shall be "new".</li>
			<li>The "old" shall be hided.</li>
		</ol>
	]]></html>
	<button label="add">
		<attribute name="onClick"><![CDATA[
			Tab tab = new Tab("Tab");
			tab.setSelected(true);
			tabs.insertBefore(tab, tabs.getFirstChild());
			Tabpanel panel = new Tabpanel();
			new Label("new").setParent(panel);
			tabpanels.insertBefore(panel, tabpanels.getFirstChild());
		]]></attribute>
	</button>
	<tabbox id="tabbox">
		<tabs id="tabs">
			<tab label="tab" />
		</tabs>
		<tabpanels id="tabpanels">
			<tabpanel>old</tabpanel>
		</tabpanels>
	</tabbox>
</zk>`,
	);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tabpanel:visible").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("new"));
});
