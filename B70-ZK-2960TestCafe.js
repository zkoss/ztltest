import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2960TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2960.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2960TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.resizeWindow(
		await ClientFunction(() => document.body.offsetWidth)(),
		800,
	);
	await t
		.wait(500)
		.click(
			Selector(
				() => jq(".z-combobox").eq(8).find(".z-combobox-button")[0],
			),
		);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-combobox").eq(8).find(".z-combobox-input").offset().top,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-combobox-popup").offset().top,
	)();
	await t.expect(verifyVariable_cafe_1_1 < verifyVariable_cafe_0_0).ok();
});
