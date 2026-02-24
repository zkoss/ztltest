import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1813518TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1813518.zhtml`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1813518TestCafe", async (t) => {
	await ztl.initTest(t);
	let borderCss_cafe = await ClientFunction(
		() => jq("@rows:eq(0) td").get(0).style.border,
	)();
	await t
		.expect(
			ztl.normalizeText("1px solid blue1px solid #0000ffblue 1px solid"),
		)
		.contains(ztl.normalizeText(borderCss_cafe), "");
	await t
		.expect(ztl.normalizeText("rgb(51, 51, 51)#333333"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() => jq("@rows:eq(0) td").css("color"))(),
			),
			"",
		);
	await t
		.expect(ztl.normalizeText("rgb(227, 235, 246)#e3ebf6"))
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@rows:eq(0) td").css("backgroundColor"),
				)(),
			),
			"",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(
					() => jq("@rows:eq(1) td").get(1).style.border,
				)(),
			),
		)
		.eql(ztl.normalizeText(""));
	let color_cafe = await ClientFunction(() =>
		jq("@rows:eq(1) td").css("color"),
	)();
	await t
		.expect(
			ztl.normalizeText(
				"rgba(0, 0, 0, 0.9)#000000rgba(0, 0, 0, 0.901961)",
			),
		)
		.contains(ztl.normalizeText(color_cafe), "");
	await t
		.expect(
			ztl.normalizeText(
				"transparent|rgb(255, 255, 255)|rgba(0, 0, 0, 0)|#ffffff",
			),
		)
		.contains(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@rows:eq(1) td").css("backgroundColor"),
				)(),
			),
			"",
		);
});
