import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3051-2TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3051-2.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3051-2TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.resizeWindow(250, 200);
	await t.wait(500).click(Selector(() => jq(".z-combobox-button")[0]));
	await ztl.waitResponse(t);
	let ppLeft_cafe = await ClientFunction(
		() => jq(".z-combobox-popup").offset().left,
	)();
	let ppTop_cafe = await ClientFunction(
		() => jq(".z-combobox-popup").offset().top,
	)();
	let ppHeight_cafe = await ClientFunction(() =>
		jq(".z-combobox-popup").outerHeight(),
	)();
	let ppWidth_cafe = await ClientFunction(() =>
		jq(".z-combobox-popup").outerWidth(),
	)();
	let inpLeft_cafe = await ClientFunction(
		() => jq(".z-combobox").offset().left,
	)();
	let inpTop_cafe = await ClientFunction(
		() => jq(".z-combobox").offset().top,
	)();
	let inpHeight_cafe = await ClientFunction(() =>
		jq(".z-combobox").outerHeight(),
	)();
	let inpWidth_cafe = await ClientFunction(() =>
		jq(".z-combobox").outerWidth(),
	)();
	await t
		.expect(
			ppLeft_cafe > inpLeft_cafe - ppWidth_cafe &&
				ppLeft_cafe < inpLeft_cafe + inpWidth_cafe &&
				ppTop_cafe > inpTop_cafe - ppHeight_cafe &&
				ppTop_cafe < inpTop_cafe + inpHeight_cafe,
		)
		.notOk();
});
