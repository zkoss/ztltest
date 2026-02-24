import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3035367TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B50-3035367TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<window title="Test Case: Updating list model of not yet rendered listbox" border="normal" width="500px" height="400px">
<tabbox height="100%" >
<tabs>
<tab id="t1" label="Visible (selected) Tab" selected="true"></tab>
<tab id="t2" label="Not visible (selected) by default" selected="false"></tab>
<tab id="t3" label="Not visible (selected) by default" selected="false"></tab>
</tabs>
<tabpanels>
<tabpanel>
<button label="update list model of listbox on second tab panel" onClick=\'listbox1.setModel(new ListModelList(Collections.singletonList("element")));\' />
<button label="update list model of grid on third tab panel" onClick=\'grid1.setModel(new ListModelList(Collections.singletonList("element")));\' />
</tabpanel>
<tabpanel>
<listbox id="listbox1" vflex="true" > <!-- if height="100%" or vflex="true": script error if button is pressed -->
<listhead>
<listheader label="Listbox" />
</listhead>
</listbox>
</tabpanel>
<tabpanel>
<grid id="grid1" vflex="true" > <!-- if height="100%" or vflex="true": script error if button is pressed -->
<columns>
<column label="Grid" />
</columns>
<rows/>
</grid>
</tabpanel>
</tabpanels>
</tabbox>
</window>`,
	);
	await t.click(
		Selector(
			() =>
				jq(
					'@button[label="update list model of listbox on second tab panel"]',
				)[0],
		),
	);
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => jq(zk.Desktop._dt.$f("t2", true))[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("@listheader")).text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Listbox"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("@listcell")).text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("element"));
	await t.click(Selector(() => jq(".z-tabbox-left-scroll")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(zk.Desktop._dt.$f("t1", true))[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button:contains(grid)")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-error")[0])()).notOk();
	await t.click(Selector(() => jq(".z-tabbox-right-scroll")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-tabbox-right-scroll")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(zk.Desktop._dt.$f("t3", true))[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("@column")).text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("Grid"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(jq("@label")).text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("element"));
});
