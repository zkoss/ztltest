import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-2199361TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-2199361.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-2199361TestCafe", async (t) => {
	await ztl.initTest(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-label:contains(Hello, Initiator)").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 2)
		.ok(
			'The label "Hello, Initiator" should be visible above the separator',
		);
});
