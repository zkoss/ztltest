import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-1683TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-1683.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-1683TestCafe", async (t) => {
	await ztl.initTest(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-window-modal").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 1)
		.ok("You should not see an endless loop for the alert message.");
	await t.click(Selector(() => jq(".z-window-close")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-window-modal").length,
	)();
	await t
		.expect(verifyVariable_cafe_1_1 == 1)
		.ok("You should not see an endless loop for the alert message.");
});
