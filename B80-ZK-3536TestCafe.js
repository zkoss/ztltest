import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3536TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3536.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3536TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menubar-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menubar-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menubar-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menubar-right")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menubar-right")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-menu:eq(11)").outerWidth(true),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-menubar-right").offset().left,
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq(".z-menu:eq(11)").offset().left,
	)();
	await t
		.expect(
			verifyVariable_cafe_2_2 + verifyVariable_cafe_0_0 <
				verifyVariable_cafe_1_1,
		)
		.ok();
});
