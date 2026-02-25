import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2519TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2519.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2519TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button:contains(change)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-label:contains(tag Label)").last().length,
	)();
	await t.expect(verifyVariable_cafe_0_0 > 0).ok();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button:contains(hide)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-error").length,
	)();
	await t.expect(verifyVariable_cafe_1_1 < 1).ok();
});
