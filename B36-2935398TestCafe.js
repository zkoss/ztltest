import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B36-2935398TestCafe`
	.page`http://localhost:8080/zktest/test2/B36-2935398.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B36-2935398TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	let b_cafe_0 = await ClientFunction(() => jq("$tb").height())();
	let b_cafe_1 = await ClientFunction(() => jq("$div").height())();
	let b_cafe = b_cafe_1 + b_cafe_0;
	await ClientFunction(
		() => {
			"window.scrollTo(0, " + b_cafe + " )";
		},
		{ dependencies: { b_cafe } },
	)();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$btn")[0]));
	await ztl.waitResponse(t);
	let eb_cafe = await ClientFunction(() => !!jq(".z-errorbox")[0])();
	let ev_cafe = await ClientFunction(() =>
		jq(".z-errorbox").is(":visible"),
	)();
	await t.expect(eb_cafe).ok();
	await t.expect(ev_cafe).ok();
	let po_cafe = await ClientFunction(
		() => jq(".z-errorbox").position().top,
	)();
	let p1_cafe = await ClientFunction(() => jq("$tb").position().top)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(po_cafe),
		ztl.normalizeText("0"),
		ztl.normalizeText("2"),
	);
	let l_cafe_2 = await ClientFunction(() => jq("$tb").outerWidth())();
	let l_cafe_3 = await ClientFunction(() => jq("$tb").offset().left)();
	let l_cafe = l_cafe_3 + l_cafe_2;
	let l1_cafe = await ClientFunction(() => jq(".z-errorbox").offset().left)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(l_cafe),
		ztl.normalizeText(l1_cafe),
		ztl.normalizeText("1"),
	);
});
