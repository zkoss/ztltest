import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1577TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1577.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1577TestCafe", async (t) => {
	await ztl.initTest(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() =>
			jq(".z-window:eq(0) .z-hlayout-inner[style*=padding-right]").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 > 0)
		.ok("Should see gap between each groupbox.");
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() =>
			jq(".z-window:eq(1) .z-vlayout-inner[style*=padding-bottom]")
				.length,
	)();
	await t
		.expect(verifyVariable_cafe_1_1 > 0)
		.ok("Should see gap between each groupbox.");
});
