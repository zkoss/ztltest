import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-4035TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4035.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4035TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.resizeWindow(500, 500);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("$s1").width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("$s2").width(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq("body").width(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq("$s1").width(),
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq("$s2").width(),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq("body").width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_0_0 + verifyVariable_cafe_1_1 + 10,
		),
		ztl.normalizeText(verifyVariable_cafe_5_5),
		ztl.normalizeText("5"),
	);
});
