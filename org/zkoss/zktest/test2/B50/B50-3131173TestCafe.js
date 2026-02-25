import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3131173TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3131173.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3131173TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@treecell:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Item 4: / selected:true"), "");
	await t.click(Selector(() => jq(".z-treerow-checkbox:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@treecell:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Item 4: / selected:false"), "");
});
