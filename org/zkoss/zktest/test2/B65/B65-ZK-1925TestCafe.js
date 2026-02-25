import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1925TestCafe`
	.page`http://localhost:8080/zktest/test2/B65-ZK-1925.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B65-ZK-1925TestCafe", async (t) => {
	await ztl.initTest(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-div:contains(inline)").eq(0).height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-div:contains(sclass)").eq(0).height(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == verifyVariable_cafe_1_1)
		.ok(
			"The Red div should have the same height, as the green divs next to them",
		);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(".z-div:contains(inline)").eq(1).height(),
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq(".z-div:contains(sclass)").eq(1).height(),
	)();
	await t
		.expect(verifyVariable_cafe_0_0t == verifyVariable_cafe_1_1t)
		.ok(
			"The Red div should have the same height, as the green divs next to them",
		);
});
