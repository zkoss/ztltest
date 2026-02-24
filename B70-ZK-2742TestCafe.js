import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2742TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2742.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2742TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-combobox-button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-combobox-popup:eq(0)").offset().top,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-combobox").height(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(".z-combobox").offset().top,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq(".z-combobox-popup:eq(0)").offset().top,
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq(".z-combobox").height(),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(
		() => jq(".z-combobox").offset().top,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2 + verifyVariable_cafe_1_1),
		ztl.normalizeText(verifyVariable_cafe_3_3),
		ztl.normalizeText("1"),
	);
});
