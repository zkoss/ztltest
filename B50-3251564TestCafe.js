import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B50-3251564TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3251564.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3251564TestCafe", async (t) => {
	await ztl.initTest(t);
	let x_cafe = await ClientFunction(() => jq("@textbox").offset().left)();
	await t.click(Selector(() => jq("@textbox")[0]));
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		jq(jq("@textbox"))[0].value = "";
	})();
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => !!jq(".z-errorbox")[0])()).ok();
	let y_cafe = await ClientFunction(
		() => jq(".z-errorbox").position().left,
	)();
	let y1_cafe = await ClientFunction(() => jq(".z-errorbox").outerWidth())();
	await t.expect(x_cafe > y_cafe).ok();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(x_cafe - y1_cafe),
		ztl.normalizeText(y_cafe),
		ztl.normalizeText("1"),
	);
});
