import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2160TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2160.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2160TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ios,android")) {
		console.log("This issue is ignored in current browser! (ios,android)");
		return;
	}
	await t.resizeWindow(1024, 300);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@menu:visible")[0]));
	await ztl.waitResponse(t);
	let rightOffset_cafe_0 = await ClientFunction(() =>
		jq("@menupopup:visible").width(),
	)();
	let rightOffset_cafe_1 = await ClientFunction(
		() => jq("@menupopup:visible").offset().left,
	)();
	let rightOffset_cafe = rightOffset_cafe_0 + rightOffset_cafe_1;
	let verifyVariable_cafe_0_2 = await ClientFunction(
		() => jq("@menu:visible").offset().left,
	)();
	await t
		.expect(rightOffset_cafe < verifyVariable_cafe_0_2)
		.ok("Menu popup should be at the left side of menu.");
	await t.wait(2500);
	let verifyVariable_cafe_1_3 = await ClientFunction(() =>
		jq("@menupopup:visible").width(),
	)();
	let verifyVariable_cafe_2_4 = await ClientFunction(
		() => jq("@menupopup:visible").offset().left,
	)();
	await t
		.expect(
			rightOffset_cafe ==
				verifyVariable_cafe_1_3 + verifyVariable_cafe_2_4,
		)
		.ok(
			"Menu popup should be at the same position after blocking 2 seconds.",
		);
});
