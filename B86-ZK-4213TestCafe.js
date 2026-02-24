import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B86-ZK-4213TestCafe`
	.page`http://localhost:8080/zktest/test2/B86-ZK-4213.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B86-ZK-4213TestCafe", async (t) => {
	await ztl.initTest(t);
	let columnsWidth_cafe_0 = await ClientFunction(() =>
		jq(".z-columns").children().eq(3).outerWidth(),
	)();
	let columnsWidth_cafe_1 = await ClientFunction(() =>
		jq(".z-columns").children().eq(1).outerWidth(),
	)();
	let columnsWidth_cafe_2 = await ClientFunction(() =>
		jq(".z-columns").children().eq(0).outerWidth(),
	)();
	let columnsWidth_cafe_3 = await ClientFunction(() =>
		jq(".z-columns").children().eq(2).outerWidth(),
	)();
	let columnsWidth_cafe =
		columnsWidth_cafe_2 +
		columnsWidth_cafe_1 +
		columnsWidth_cafe_3 +
		columnsWidth_cafe_0;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(columnsWidth_cafe),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-grid").outerWidth())(),
		),
		ztl.normalizeText("2"),
	);
	await t.resizeWindow(800, 800);
	await ztl.waitResponse(t);
	let columnsWidth_cafe_0t = await ClientFunction(() =>
		jq(".z-columns").children().eq(3).outerWidth(),
	)();
	let columnsWidth_cafe_1t = await ClientFunction(() =>
		jq(".z-columns").children().eq(1).outerWidth(),
	)();
	let columnsWidth_cafe_2t = await ClientFunction(() =>
		jq(".z-columns").children().eq(0).outerWidth(),
	)();
	let columnsWidth_cafe_3t = await ClientFunction(() =>
		jq(".z-columns").children().eq(2).outerWidth(),
	)();
	let columnsWidth_cafet =
		columnsWidth_cafe_2t +
		columnsWidth_cafe_1t +
		columnsWidth_cafe_3t +
		columnsWidth_cafe_0t;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(columnsWidth_cafet),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-grid").outerWidth())(),
		),
		ztl.normalizeText("2"),
	);
	await ztl.doScroll({
		locator: Selector(() => jq(".z-grid")[0]),
		scrollType: "vertical",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let columnsWidth_cafe_0tt = await ClientFunction(() =>
		jq(".z-columns").children().eq(3).outerWidth(),
	)();
	let columnsWidth_cafe_1tt = await ClientFunction(() =>
		jq(".z-columns").children().eq(1).outerWidth(),
	)();
	let columnsWidth_cafe_2tt = await ClientFunction(() =>
		jq(".z-columns").children().eq(0).outerWidth(),
	)();
	let columnsWidth_cafe_3tt = await ClientFunction(() =>
		jq(".z-columns").children().eq(2).outerWidth(),
	)();
	let columnsWidth_cafett =
		columnsWidth_cafe_2tt +
		columnsWidth_cafe_1tt +
		columnsWidth_cafe_3tt +
		columnsWidth_cafe_0tt;
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(columnsWidth_cafett),
		ztl.normalizeText(
			await ClientFunction(() => jq(".z-grid").outerWidth())(),
		),
		ztl.normalizeText("2"),
	);
});
