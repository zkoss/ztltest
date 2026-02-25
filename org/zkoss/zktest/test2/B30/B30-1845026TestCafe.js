import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1845026TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1845026.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1845026TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(
		Selector(() => jq("@treerow:eq(0)")[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@treerow:eq(0)")[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq("$txtbox").focus();
	})();
	await t.typeText(
		Selector(() => jq("$txtbox")[0]),
		ztl.normalizeText("a"),
	);
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq("@treerow:eq(1)")[0]),
		{ offsetX: 1, offsetY: 1 },
	);
	await ztl.waitResponse(t);
	let rowText_cafe = await ClientFunction(() =>
		jq("@treerow:eq(0)").text().replace(/\s/g, " "),
	)();
	await t
		.expect(rowText_cafe != null && rowText_cafe.indexOf("a") != -1)
		.ok();
});
