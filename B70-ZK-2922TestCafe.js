import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2922TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2922.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2922TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-intbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 1).ok();
	await t.click(Selector(() => jq(".z-intbox")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_1_1 == 2).ok();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_2_2 == 2).ok();
	await t.click(Selector(() => jq(".z-intbox")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1t = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_1_1t == 2).ok();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2t = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_2_2t == 2).ok();
	await t.click(Selector(() => jq(".z-intbox")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1tt = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_1_1tt == 2).ok();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tt = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_2_2tt == 2).ok();
	await t.click(Selector(() => jq(".z-intbox")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1ttt = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_1_1ttt == 2).ok();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2ttt = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_2_2ttt == 2).ok();
	await t.click(Selector(() => jq(".z-intbox")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1tttt = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_1_1tttt == 2).ok();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	let verifyVariable_cafe_2_2tttt = await ClientFunction(
		() => jq(".z-errorbox").length,
	)();
	await t.expect(verifyVariable_cafe_2_2tttt == 2).ok();
});
