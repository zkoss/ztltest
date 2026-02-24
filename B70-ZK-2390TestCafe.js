import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2390TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2390.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2390TestCafe", async (t) => {
	await ztl.initTest(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@hlayout").width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq("@hlayout").offset().left,
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq("@window").offset().left,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq("@window").outerWidth(),
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq("@hlayout").width(),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(
		() => jq("@hlayout").offset().left,
	)();
	let verifyVariable_cafe_6_6 = await ClientFunction(
		() => jq("@window").offset().left,
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(() =>
		jq("@window").outerWidth(),
	)();
	await t
		.expect(
			ztl.normalizeText(
				verifyVariable_cafe_6_6 + verifyVariable_cafe_7_7,
			),
		)
		.eql(
			ztl.normalizeText(
				verifyVariable_cafe_1_1 + verifyVariable_cafe_0_0,
			),
			"window should be extended to right edge.",
		);
});
