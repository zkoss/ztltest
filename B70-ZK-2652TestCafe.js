import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2652TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2652.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2652TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("@chosenbox")[0]));
	await ztl.waitResponse(t);
	let originTop_cafe = await ClientFunction(
		() => jq(".z-chosenbox-popup").position().top,
	)();
	await ztl.doScroll({
		locator: Selector(() => jq("@window")[0]),
		scrollType: "vertical",
		percent: "70.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-chosenbox-popup").position().top,
	)();
	await t.expect(verifyVariable_cafe_0_0 < originTop_cafe).ok();
});
