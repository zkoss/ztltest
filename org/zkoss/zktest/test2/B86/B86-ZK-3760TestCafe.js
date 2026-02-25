import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B86-ZK-3760TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-3760.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-3760TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@center")[0]),
		scrollType: "vertical",
		dist: "500",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$contact")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("$contact").height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq("$level1").offset().top,
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq("$contact").offset().top,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq("$contact").height(),
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(
		() => jq("$level1").offset().top,
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(
		() => jq("$contact").offset().top,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0 + verifyVariable_cafe_2_2),
		ztl.normalizeText(verifyVariable_cafe_4_4),
		ztl.normalizeText("10"),
	);
	await t.click(Selector(() => jq("$settings")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_6_6 = await ClientFunction(() =>
		jq("$level1").height(),
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(
		() => jq("$level1").offset().top,
	)();
	let verifyVariable_cafe_8_8 = await ClientFunction(
		() => jq("$level2").offset().top,
	)();
	let verifyVariable_cafe_9_9 = await ClientFunction(() =>
		jq("$level1").height(),
	)();
	let verifyVariable_cafe_10_10 = await ClientFunction(
		() => jq("$level1").offset().top,
	)();
	let verifyVariable_cafe_11_11 = await ClientFunction(
		() => jq("$level2").offset().top,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_6_6 + verifyVariable_cafe_7_7),
		ztl.normalizeText(verifyVariable_cafe_11_11),
		ztl.normalizeText("10"),
	);
});
