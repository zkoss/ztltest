import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3285714TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3285714.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3285714TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@grid")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await t.wait(1000);
	await ztl.doScroll({
		locator: Selector(() => jq("@grid")[0]),
		scrollType: "vertical",
		percent: "50.0",
	});
	await ztl.waitResponse(t);
	await t.wait(1000);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq("@row:contains(Row 5000)").offset().top,
	)();
	await t.expect(verifyVariable_cafe_0_0 > 0).ok();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("@grid").innerHeight(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq("@row:contains(Row 5000)").offset().top,
	)();
	await t.expect(verifyVariable_cafe_2_2 < verifyVariable_cafe_1_1).ok();
});
