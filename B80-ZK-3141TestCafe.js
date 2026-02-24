import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3141TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3141.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3141TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq("@textbox").focus();
	})();
	await t.pressKey("tab");
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-errorbox:visible").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 > 0).ok();
	let tbMidX_cafe_1 = await ClientFunction(() =>
		jq("@textbox").outerWidth(),
	)();
	let tbMidX_cafe_2 = await ClientFunction(
		() => jq("@textbox").offset().left,
	)();
	let tbMidX_cafe = tbMidX_cafe_2 + tbMidX_cafe_1 / 2;
	let ptrMidX_cafe_3 = await ClientFunction(() =>
		jq(".z-errorbox-pointer:visible").outerWidth(),
	)();
	let ptrMidX_cafe_4 = await ClientFunction(
		() => jq(".z-errorbox-pointer:visible").offset().left,
	)();
	let ptrMidX_cafe = ptrMidX_cafe_4 + ptrMidX_cafe_3 / 2;
	let tbWidthTol_cafe_5 = await ClientFunction(() =>
		jq("@textbox").outerWidth(),
	)();
	let tbWidthTol_cafe = tbWidthTol_cafe_5 / 2 + 5;
	let tbMidY_cafe_6 = await ClientFunction(() =>
		jq("@textbox").outerHeight(),
	)();
	let tbMidY_cafe_7 = await ClientFunction(
		() => jq("@textbox").offset().top,
	)();
	let tbMidY_cafe = tbMidY_cafe_7 + tbMidY_cafe_6 / 2;
	let ptrMidY_cafe_8 = await ClientFunction(() =>
		jq(".z-errorbox-pointer:visible").outerHeight(),
	)();
	let ptrMidY_cafe_9 = await ClientFunction(
		() => jq(".z-errorbox-pointer:visible").offset().top,
	)();
	let ptrMidY_cafe = ptrMidY_cafe_9 + ptrMidY_cafe_8 / 2;
	let tbHeightTol_cafe_10 = await ClientFunction(() =>
		jq("@textbox").outerHeight(),
	)();
	let tbHeightTol_cafe = tbHeightTol_cafe_10 / 2 + 5;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(tbMidY_cafe),
		ztl.normalizeText(ptrMidY_cafe),
		ztl.normalizeText(tbHeightTol_cafe),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(tbMidX_cafe),
		ztl.normalizeText(ptrMidX_cafe),
		ztl.normalizeText(tbWidthTol_cafe),
	);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	let tbMidX_cafe_1t = await ClientFunction(() =>
		jq("@textbox").outerWidth(),
	)();
	let tbMidX_cafe_2t = await ClientFunction(
		() => jq("@textbox").offset().left,
	)();
	let tbMidX_cafet = tbMidX_cafe_2t + tbMidX_cafe_1t / 2;
	let ptrMidX_cafe_3t = await ClientFunction(() =>
		jq(".z-errorbox-pointer:visible").outerWidth(),
	)();
	let ptrMidX_cafe_4t = await ClientFunction(
		() => jq(".z-errorbox-pointer:visible").offset().left,
	)();
	let ptrMidX_cafet = ptrMidX_cafe_4t + ptrMidX_cafe_3t / 2;
	let tbWidthTol_cafe_5t = await ClientFunction(() =>
		jq("@textbox").outerWidth(),
	)();
	let tbWidthTol_cafet = tbWidthTol_cafe_5t / 2 + 5;
	let tbMidY_cafe_6t = await ClientFunction(() =>
		jq("@textbox").outerHeight(),
	)();
	let tbMidY_cafe_7t = await ClientFunction(
		() => jq("@textbox").offset().top,
	)();
	let tbMidY_cafet = tbMidY_cafe_7t + tbMidY_cafe_6t / 2;
	let ptrMidY_cafe_8t = await ClientFunction(() =>
		jq(".z-errorbox-pointer:visible").outerHeight(),
	)();
	let ptrMidY_cafe_9t = await ClientFunction(
		() => jq(".z-errorbox-pointer:visible").offset().top,
	)();
	let ptrMidY_cafet = ptrMidY_cafe_9t + ptrMidY_cafe_8t / 2;
	let tbHeightTol_cafe_10t = await ClientFunction(() =>
		jq("@textbox").outerHeight(),
	)();
	let tbHeightTol_cafet = tbHeightTol_cafe_10t / 2 + 5;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(tbMidY_cafet),
		ztl.normalizeText(ptrMidY_cafet),
		ztl.normalizeText(tbHeightTol_cafet),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(tbMidX_cafet),
		ztl.normalizeText(ptrMidX_cafet),
		ztl.normalizeText(tbWidthTol_cafet),
	);
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await ztl.waitResponse(t);
	let tbMidX_cafe_1tt = await ClientFunction(() =>
		jq("@textbox").outerWidth(),
	)();
	let tbMidX_cafe_2tt = await ClientFunction(
		() => jq("@textbox").offset().left,
	)();
	let tbMidX_cafett = tbMidX_cafe_2tt + tbMidX_cafe_1tt / 2;
	let ptrMidX_cafe_3tt = await ClientFunction(() =>
		jq(".z-errorbox-pointer:visible").outerWidth(),
	)();
	let ptrMidX_cafe_4tt = await ClientFunction(
		() => jq(".z-errorbox-pointer:visible").offset().left,
	)();
	let ptrMidX_cafett = ptrMidX_cafe_4tt + ptrMidX_cafe_3tt / 2;
	let tbWidthTol_cafe_5tt = await ClientFunction(() =>
		jq("@textbox").outerWidth(),
	)();
	let tbWidthTol_cafett = tbWidthTol_cafe_5tt / 2 + 5;
	let tbMidY_cafe_6tt = await ClientFunction(() =>
		jq("@textbox").outerHeight(),
	)();
	let tbMidY_cafe_7tt = await ClientFunction(
		() => jq("@textbox").offset().top,
	)();
	let tbMidY_cafett = tbMidY_cafe_7tt + tbMidY_cafe_6tt / 2;
	let ptrMidY_cafe_8tt = await ClientFunction(() =>
		jq(".z-errorbox-pointer:visible").outerHeight(),
	)();
	let ptrMidY_cafe_9tt = await ClientFunction(
		() => jq(".z-errorbox-pointer:visible").offset().top,
	)();
	let ptrMidY_cafett = ptrMidY_cafe_9tt + ptrMidY_cafe_8tt / 2;
	let tbHeightTol_cafe_10tt = await ClientFunction(() =>
		jq("@textbox").outerHeight(),
	)();
	let tbHeightTol_cafett = tbHeightTol_cafe_10tt / 2 + 5;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(tbMidY_cafett),
		ztl.normalizeText(ptrMidY_cafett),
		ztl.normalizeText(tbHeightTol_cafett),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(tbMidX_cafett),
		ztl.normalizeText(ptrMidX_cafett),
		ztl.normalizeText(tbWidthTol_cafett),
	);
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await ztl.waitResponse(t);
	let tbMidX_cafe_1ttt = await ClientFunction(() =>
		jq("@textbox").outerWidth(),
	)();
	let tbMidX_cafe_2ttt = await ClientFunction(
		() => jq("@textbox").offset().left,
	)();
	let tbMidX_cafettt = tbMidX_cafe_2ttt + tbMidX_cafe_1ttt / 2;
	let ptrMidX_cafe_3ttt = await ClientFunction(() =>
		jq(".z-errorbox-pointer:visible").outerWidth(),
	)();
	let ptrMidX_cafe_4ttt = await ClientFunction(
		() => jq(".z-errorbox-pointer:visible").offset().left,
	)();
	let ptrMidX_cafettt = ptrMidX_cafe_4ttt + ptrMidX_cafe_3ttt / 2;
	let tbWidthTol_cafe_5ttt = await ClientFunction(() =>
		jq("@textbox").outerWidth(),
	)();
	let tbWidthTol_cafettt = tbWidthTol_cafe_5ttt / 2 + 5;
	let tbMidY_cafe_6ttt = await ClientFunction(() =>
		jq("@textbox").outerHeight(),
	)();
	let tbMidY_cafe_7ttt = await ClientFunction(
		() => jq("@textbox").offset().top,
	)();
	let tbMidY_cafettt = tbMidY_cafe_7ttt + tbMidY_cafe_6ttt / 2;
	let ptrMidY_cafe_8ttt = await ClientFunction(() =>
		jq(".z-errorbox-pointer:visible").outerHeight(),
	)();
	let ptrMidY_cafe_9ttt = await ClientFunction(
		() => jq(".z-errorbox-pointer:visible").offset().top,
	)();
	let ptrMidY_cafettt = ptrMidY_cafe_9ttt + ptrMidY_cafe_8ttt / 2;
	let tbHeightTol_cafe_10ttt = await ClientFunction(() =>
		jq("@textbox").outerHeight(),
	)();
	let tbHeightTol_cafettt = tbHeightTol_cafe_10ttt / 2 + 5;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(tbMidY_cafettt),
		ztl.normalizeText(ptrMidY_cafettt),
		ztl.normalizeText(tbHeightTol_cafettt),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(tbMidX_cafettt),
		ztl.normalizeText(ptrMidX_cafettt),
		ztl.normalizeText(tbWidthTol_cafettt),
	);
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await ztl.waitResponse(t);
	await t.drag(
		Selector(() => jq(".z-window-header")[0]),
		20,
		20,
		{ offsetX: 10, offsetY: 10 },
	);
	await ztl.waitResponse(t);
	let tbMidX_cafe_1tttt = await ClientFunction(() =>
		jq("@textbox").outerWidth(),
	)();
	let tbMidX_cafe_2tttt = await ClientFunction(
		() => jq("@textbox").offset().left,
	)();
	let tbMidX_cafetttt = tbMidX_cafe_2tttt + tbMidX_cafe_1tttt / 2;
	let ptrMidX_cafe_3tttt = await ClientFunction(() =>
		jq(".z-errorbox-pointer:visible").outerWidth(),
	)();
	let ptrMidX_cafe_4tttt = await ClientFunction(
		() => jq(".z-errorbox-pointer:visible").offset().left,
	)();
	let ptrMidX_cafetttt = ptrMidX_cafe_4tttt + ptrMidX_cafe_3tttt / 2;
	let tbWidthTol_cafe_5tttt = await ClientFunction(() =>
		jq("@textbox").outerWidth(),
	)();
	let tbWidthTol_cafetttt = tbWidthTol_cafe_5tttt / 2 + 5;
	let tbMidY_cafe_6tttt = await ClientFunction(() =>
		jq("@textbox").outerHeight(),
	)();
	let tbMidY_cafe_7tttt = await ClientFunction(
		() => jq("@textbox").offset().top,
	)();
	let tbMidY_cafetttt = tbMidY_cafe_7tttt + tbMidY_cafe_6tttt / 2;
	let ptrMidY_cafe_8tttt = await ClientFunction(() =>
		jq(".z-errorbox-pointer:visible").outerHeight(),
	)();
	let ptrMidY_cafe_9tttt = await ClientFunction(
		() => jq(".z-errorbox-pointer:visible").offset().top,
	)();
	let ptrMidY_cafetttt = ptrMidY_cafe_9tttt + ptrMidY_cafe_8tttt / 2;
	let tbHeightTol_cafe_10tttt = await ClientFunction(() =>
		jq("@textbox").outerHeight(),
	)();
	let tbHeightTol_cafetttt = tbHeightTol_cafe_10tttt / 2 + 5;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(tbMidY_cafetttt),
		ztl.normalizeText(ptrMidY_cafetttt),
		ztl.normalizeText(tbHeightTol_cafetttt),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(tbMidX_cafetttt),
		ztl.normalizeText(ptrMidX_cafetttt),
		ztl.normalizeText(tbWidthTol_cafetttt),
	);
});
