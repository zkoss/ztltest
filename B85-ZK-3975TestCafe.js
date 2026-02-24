import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3975TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3975.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3975TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.doScroll({
		locator: Selector(() => jq("@listbox")[0]),
		scrollType: "vertical",
		percent: "1.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listgroup-icon-open").eq(2)[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-listgroup").eq(2).height(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("@listbox").height(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() => jq("@listbox").offset().top,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(
		() => jq(".z-listgroup").eq(2).offset().top,
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq(".z-listgroup").eq(2).height(),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq("@listbox").height(),
	)();
	let verifyVariable_cafe_6_6 = await ClientFunction(
		() => jq("@listbox").offset().top,
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(
		() => jq(".z-listgroup").eq(2).offset().top,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1 + verifyVariable_cafe_2_2),
		ztl.normalizeText(verifyVariable_cafe_7_7 + verifyVariable_cafe_4_4),
		ztl.normalizeText("1"),
	);
});
