import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B60-ZK-726TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-726.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-726TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.wait(1000);
	let divLeft_cafe = await ClientFunction(
		() => jq(".z-apply-mask").offset().left,
	)();
	let divTop_cafe = await ClientFunction(
		() => jq(".z-apply-mask").offset().top,
	)();
	let loadingLeft_cafe = await ClientFunction(
		() => jq(".z-apply-loading").offset().left,
	)();
	let loadingTop_cafe = await ClientFunction(
		() => jq(".z-apply-loading").offset().top,
	)();
	await t.expect(divLeft_cafe <= loadingLeft_cafe).ok();
	await t.expect(divTop_cafe <= loadingTop_cafe).ok();
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-apply-loading").width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-apply-mask").width(),
	)();
	await t
		.expect(
			loadingLeft_cafe + verifyVariable_cafe_0_0 <=
				divLeft_cafe + verifyVariable_cafe_1_1,
		)
		.ok();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(".z-apply-mask").height(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(".z-apply-loading").height(),
	)();
	await t
		.expect(
			loadingTop_cafe + verifyVariable_cafe_3_3 <=
				divTop_cafe + verifyVariable_cafe_2_2,
		)
		.ok();
});
