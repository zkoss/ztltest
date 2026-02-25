import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3008TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3008.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3008TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ClientFunction(
			() =>
				jq(jq(".z-combobox").find(".z-combobox-input"))[0] !=
				document.activeElement,
		)()
	)
		await t.click(
			Selector(() => jq(".z-combobox").find(".z-combobox-input")[0]),
		);
	await ztl.waitResponse(t);
	await t.pressKey("g e");
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-combobox-popup").outerHeight(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-combobox").offset().top,
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(".z-combobox-popup").offset().top,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(".z-combobox-popup").outerHeight(),
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(
		() => jq(".z-combobox").offset().top,
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(
		() => jq(".z-combobox-popup").offset().top,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1),
		ztl.normalizeText(verifyVariable_cafe_3_3 + verifyVariable_cafe_5_5),
		ztl.normalizeText("3"),
	);
	await t.pressKey("backspace");
	await ztl.waitResponse(t);
	await t.pressKey("backspace");
	await ztl.waitResponse(t);
	let verifyVariable_cafe_6_6 = await ClientFunction(() =>
		jq(".z-combobox-popup").outerHeight(),
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(
		() => jq(".z-combobox").offset().top,
	)();
	let verifyVariable_cafe_8_8 = await ClientFunction(
		() => jq(".z-combobox-popup").offset().top,
	)();
	let verifyVariable_cafe_9_9 = await ClientFunction(() =>
		jq(".z-combobox-popup").outerHeight(),
	)();
	let verifyVariable_cafe_10_10 = await ClientFunction(
		() => jq(".z-combobox").offset().top,
	)();
	let verifyVariable_cafe_11_11 = await ClientFunction(
		() => jq(".z-combobox-popup").offset().top,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_7_7),
		ztl.normalizeText(verifyVariable_cafe_9_9 + verifyVariable_cafe_11_11),
		ztl.normalizeText("3"),
	);
});
