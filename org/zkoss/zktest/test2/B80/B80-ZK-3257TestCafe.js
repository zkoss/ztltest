import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3257TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3257.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3257TestCafe", async (t) => {
	await ztl.initTest(t);
	let m1l_cafe = await ClientFunction(
		() => jq("@menu:eq(0)").offset().left,
	)();
	let m2l_cafe = await ClientFunction(
		() => jq("@menu:eq(1)").offset().left,
	)();
	await t.click(Selector(() => jq("@menu:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@menu:eq(0)").offset().left)(),
			),
		)
		.eql(ztl.normalizeText(m1l_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@menu:eq(0)").css("position"))(),
			),
		)
		.notEql(ztl.normalizeText("fixed"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@menu:eq(1)").offset().left)(),
			),
		)
		.eql(ztl.normalizeText(m2l_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@menu:eq(1)").css("position"))(),
			),
		)
		.notEql(ztl.normalizeText("fixed"), "");
});
