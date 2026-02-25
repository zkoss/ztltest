import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2124391TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-2124391.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-2124391TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@treeitem:eq(0)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Group0"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@treeitem:eq(1)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Group1"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@treeitem:eq(2)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Group2"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@treeitem:eq(3)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Group3"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@treeitem:eq(4)").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("Group4"), "");
});
