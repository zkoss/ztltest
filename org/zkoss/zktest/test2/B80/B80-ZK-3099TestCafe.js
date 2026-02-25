import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3099TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3099.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3099TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ClientFunction(() => {
		jq(".z-window-content")[0].scrollTop = -100;
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-errorbox").offset().left,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq("@textbox").offset().left,
	)();
	await t.expect(verifyVariable_cafe_0_0 < verifyVariable_cafe_1_1).ok();
});
