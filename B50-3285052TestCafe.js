import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3285052TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3285052TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<zk>
	<html><![CDATA[
		<ol>
			<li>Select tab 3.</li>
			<li>Remove tab 1, tab 2.</li>
			<li>Select tab 5. If you see two Tabpanels, it is a bug.</li>
		</ol>
	]]></html>
	<tabbox width="500px">
		<tabs>
			<tab label="Tab 1" closable="true" />
			<tab label="Tab 2" closable="true" />
			<tab label="Tab 3" closable="true" />
			<tab label="Tab 4" closable="true" />
			<tab label="Tab 5" closable="true" />
			<tab label="Tab 6" closable="true" />
		</tabs>
		<tabpanels>
			<tabpanel>This is panel 1</tabpanel>
			<tabpanel>This is panel 2</tabpanel>
			<tabpanel>This is panel 3</tabpanel>
			<tabpanel>This is panel 4</tabpanel>
			<tabpanel>This is panel 5</tabpanel>
			<tabpanel>This is panel 6</tabpanel>
		</tabpanels>
	</tabbox>
</zk>`,
	);
	await t.click(Selector(() => jq('@tab[label="Tab 3"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-tab:eq(0)")).$n("cls")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => zk.Widget.$(jq(".z-tab:eq(0)")).$n("cls")));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@tab[label="Tab 5"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@tabpanel:visible").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("This is panel 5"));
});
