import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1425TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1425.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1425TestCafe", async (t) => {
	await ztl.initTest(t);
	let ft1Width_cafe = await ClientFunction(() =>
		jq("@listfooter:eq(0)").width(),
	)();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@listfooter:eq(0)").width(),
	)();
	await t.expect(verifyVariable_cafe_0_0 < ft1Width_cafe).ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq("@listfooter:eq(0)").is(":visible"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@listfooter:eq(0)").width())(),
			),
		)
		.eql(ztl.normalizeText(ft1Width_cafe));
});
