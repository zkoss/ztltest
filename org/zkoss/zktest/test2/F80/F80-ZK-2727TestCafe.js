import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F80-ZK-2727TestCafe`
	.page`http://localhost:8080/zktest/test2/F80-ZK-2727.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("F80-ZK-2727TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	let count_cafe = await ClientFunction(() => jq("@window").length)();
	await ztl.doScroll({
		locator: Selector(() => jq("@scrollview")[0]),
		scrollType: "horizontal",
		noBody: true,
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq("@window").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 > count_cafe).ok();
	count_cafe = await ClientFunction(() => jq("@window").length)();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@scrollview")[0]),
		scrollType: "vertical",
		noBody: true,
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq("@window").length,
	)();
	await t.expect(verifyVariable_cafe_1_1 > count_cafe).ok();
});
