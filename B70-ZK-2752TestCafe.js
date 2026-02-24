import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2752TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2752.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2752TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			await ClientFunction(() => jq("@grid @row:first").is(":visible"))(),
		)
		.notOk();
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@grid @row:last @label").outerHeight(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("@grid @row:last @textbox").outerHeight(),
	)();
	await t.expect(verifyVariable_cafe_0_0 < verifyVariable_cafe_1_1).ok();
});
