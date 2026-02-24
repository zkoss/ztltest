import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B30-1892484TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1892484.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1892484TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => jq(".z-tree:eq(0)").is(":visible"))(),
		)
		.ok();
	await t
		.expect(
			await ClientFunction(() => jq(".z-tree:eq(1)").is(":visible"))(),
		)
		.ok();
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	let txt1_cafe = await ClientFunction(() =>
		jq(jq(".z-tree:eq(0) .z-treecell:eq(2)")).text().replace(/\s/g, " "),
	)();
	let txt2_cafe = await ClientFunction(() =>
		jq(jq(".z-tree:eq(1) .z-treecell:eq(2)")).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(txt1_cafe))
		.contains(ztl.normalizeText("[Clinton, Obama]"), "");
	await t
		.expect(ztl.normalizeText(txt2_cafe))
		.contains(ztl.normalizeText("Matter"), "");
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	let txt21_cafe = await ClientFunction(() =>
		jq(jq(".z-tree:eq(0) .z-treecell:eq(2)")).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(txt21_cafe))
		.contains(ztl.normalizeText("[Clinton, Obama]"), "");
	let txt22_cafe = await ClientFunction(() =>
		jq(jq(".z-tree:eq(1) .z-treecell:eq(2)")).text().replace(/\s/g, " "),
	)();
	await t
		.expect(ztl.normalizeText(txt22_cafe))
		.contains(ztl.normalizeText("[Clinton, Obama]"), "");
});
