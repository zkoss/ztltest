import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-2772-3TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-2772-3.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-2772-3TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		recordColsWidth();
	})();
	await t.click(
		Selector(() => jq(".z-column").eq(5)[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = parseInt(
		await ClientFunction(() => getRecordedColWidth(0))(),
	);
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-column").eq(0).outerWidth(),
	)();
	let verifyVariable_cafe_2_2 = parseInt(
		await ClientFunction(() => getRecordedColWidth(0))(),
	);
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(".z-column").eq(0).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0),
		ztl.normalizeText(verifyVariable_cafe_3_3),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0t = parseInt(
		await ClientFunction(() => getRecordedColWidth(1))(),
	);
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq(".z-column").eq(1).outerWidth(),
	)();
	let verifyVariable_cafe_2_2t = parseInt(
		await ClientFunction(() => getRecordedColWidth(1))(),
	);
	let verifyVariable_cafe_3_3t = await ClientFunction(() =>
		jq(".z-column").eq(1).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0t),
		ztl.normalizeText(verifyVariable_cafe_3_3t),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0tt = parseInt(
		await ClientFunction(() => getRecordedColWidth(2))(),
	);
	let verifyVariable_cafe_1_1tt = await ClientFunction(() =>
		jq(".z-column").eq(2).outerWidth(),
	)();
	let verifyVariable_cafe_2_2tt = parseInt(
		await ClientFunction(() => getRecordedColWidth(2))(),
	);
	let verifyVariable_cafe_3_3tt = await ClientFunction(() =>
		jq(".z-column").eq(2).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0tt),
		ztl.normalizeText(verifyVariable_cafe_3_3tt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0ttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(3))(),
	);
	let verifyVariable_cafe_1_1ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).outerWidth(),
	)();
	let verifyVariable_cafe_2_2ttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(3))(),
	);
	let verifyVariable_cafe_3_3ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0ttt),
		ztl.normalizeText(verifyVariable_cafe_3_3ttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0tttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(4))(),
	);
	let verifyVariable_cafe_1_1tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).outerWidth(),
	)();
	let verifyVariable_cafe_2_2tttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(4))(),
	);
	let verifyVariable_cafe_3_3tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0tttt),
		ztl.normalizeText(verifyVariable_cafe_3_3tttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0ttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(5))(),
	);
	let verifyVariable_cafe_1_1ttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).outerWidth(),
	)();
	let verifyVariable_cafe_2_2ttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(5))(),
	);
	let verifyVariable_cafe_3_3ttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0ttttt),
		ztl.normalizeText(verifyVariable_cafe_3_3ttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0tttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(6))(),
	);
	let verifyVariable_cafe_1_1tttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let verifyVariable_cafe_2_2tttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(6))(),
	);
	let verifyVariable_cafe_3_3tttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0tttttt),
		ztl.normalizeText(verifyVariable_cafe_3_3tttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0ttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(7))(),
	);
	let verifyVariable_cafe_1_1ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).outerWidth(),
	)();
	let verifyVariable_cafe_2_2ttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(7))(),
	);
	let verifyVariable_cafe_3_3ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0ttttttt),
		ztl.normalizeText(verifyVariable_cafe_3_3ttttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0tttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(8))(),
	);
	let verifyVariable_cafe_1_1tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).outerWidth(),
	)();
	let verifyVariable_cafe_2_2tttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(8))(),
	);
	let verifyVariable_cafe_3_3tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0tttttttt),
		ztl.normalizeText(verifyVariable_cafe_3_3tttttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0ttttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(9))(),
	);
	let verifyVariable_cafe_1_1ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).outerWidth(),
	)();
	let verifyVariable_cafe_2_2ttttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(9))(),
	);
	let verifyVariable_cafe_3_3ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_0_0ttttttttt),
		ztl.normalizeText(verifyVariable_cafe_3_3ttttttttt),
		ztl.normalizeText("1"),
	);
	await ClientFunction(() => {
		zk.Widget.$(".z-frozen").$n("scrollX").scrollLeft =
			zk.Widget.$(".z-frozen").$n("scrollX").scrollWidth;
	})();
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => jq(".z-column").last()[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_4 = parseInt(
		await ClientFunction(() => getRecordedColWidth(0))(),
	);
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq(".z-column").eq(0).outerWidth(),
	)();
	let verifyVariable_cafe_6_6 = parseInt(
		await ClientFunction(() => getRecordedColWidth(0))(),
	);
	let verifyVariable_cafe_7_7 = await ClientFunction(() =>
		jq(".z-column").eq(0).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4),
		ztl.normalizeText(verifyVariable_cafe_7_7),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_4t = parseInt(
		await ClientFunction(() => getRecordedColWidth(1))(),
	);
	let verifyVariable_cafe_5_5t = await ClientFunction(() =>
		jq(".z-column").eq(1).outerWidth(),
	)();
	let verifyVariable_cafe_6_6t = parseInt(
		await ClientFunction(() => getRecordedColWidth(1))(),
	);
	let verifyVariable_cafe_7_7t = await ClientFunction(() =>
		jq(".z-column").eq(1).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4t),
		ztl.normalizeText(verifyVariable_cafe_7_7t),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_4tt = parseInt(
		await ClientFunction(() => getRecordedColWidth(2))(),
	);
	let verifyVariable_cafe_5_5tt = await ClientFunction(() =>
		jq(".z-column").eq(2).outerWidth(),
	)();
	let verifyVariable_cafe_6_6tt = parseInt(
		await ClientFunction(() => getRecordedColWidth(2))(),
	);
	let verifyVariable_cafe_7_7tt = await ClientFunction(() =>
		jq(".z-column").eq(2).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4tt),
		ztl.normalizeText(verifyVariable_cafe_7_7tt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_4ttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(3))(),
	);
	let verifyVariable_cafe_5_5ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).outerWidth(),
	)();
	let verifyVariable_cafe_6_6ttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(3))(),
	);
	let verifyVariable_cafe_7_7ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4ttt),
		ztl.normalizeText(verifyVariable_cafe_7_7ttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_4tttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(4))(),
	);
	let verifyVariable_cafe_5_5tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).outerWidth(),
	)();
	let verifyVariable_cafe_6_6tttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(4))(),
	);
	let verifyVariable_cafe_7_7tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4tttt),
		ztl.normalizeText(verifyVariable_cafe_7_7tttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_4ttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(9))(),
	);
	let verifyVariable_cafe_5_5ttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).outerWidth(),
	)();
	let verifyVariable_cafe_6_6ttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(9))(),
	);
	let verifyVariable_cafe_7_7ttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_4_4ttttt),
		ztl.normalizeText(verifyVariable_cafe_7_7ttttt),
		ztl.normalizeText("1"),
	);
	await ClientFunction(() => {
		var w = zk.mobile
			? jq(".z-column:eq(5)").width() + jq(".z-column:eq(6)").width()
			: 0;
		zk.Widget.$(".z-frozen").$n("scrollX").scrollLeft = w;
	})();
	await ztl.waitResponse(t);
	let width_0_cafe = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let actionVariable_cafe_0_8 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerHeight(),
	)();
	let actionVariable_cafe_1_9 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let actionVariable_cafe_2_10 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let actionVariable_cafe_3_11 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerHeight(),
	)();
	let actionVariable_cafe_4_12 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerHeight(),
	)();
	let actionVariable_cafe_5_13 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let actionVariable_cafe_6_14 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let actionVariable_cafe_7_15 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerHeight(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_5_13 + 100 + "," + actionVariable_cafe_4_12 / 2,
	);

	let cafeCoord_2 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_1_9 + "," + actionVariable_cafe_0_8 / 2,
		true,
	);

	await t.drag(
		Selector(() => jq(".z-column").eq(6)[0]),
		cafeCoord_1[0] - cafeCoord_2[0],
		cafeCoord_1[1] - cafeCoord_2[1],
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	await ztl.waitResponse(t);
	await ClientFunction(() => {
		recordColsWidth();
	})();
	await ClientFunction(() => {
		if (zk.mobile)
			zk.Widget.$(".z-frozen").$n("scrollX").scrollLeft =
				jq(".z-column:eq(5)").width() +
				jq(".z-column:eq(6)").width() / 2;
	})();
	await t.click(
		Selector(() => jq(".z-column").eq(6)[0]),
		{ offsetX: 2, offsetY: 2 },
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_8_16 = parseInt(
		await ClientFunction(() => getRecordedColWidth(0))(),
	);
	let verifyVariable_cafe_9_17 = await ClientFunction(() =>
		jq(".z-column").eq(0).outerWidth(),
	)();
	let verifyVariable_cafe_10_18 = parseInt(
		await ClientFunction(() => getRecordedColWidth(0))(),
	);
	let verifyVariable_cafe_11_19 = await ClientFunction(() =>
		jq(".z-column").eq(0).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_8_16),
		ztl.normalizeText(verifyVariable_cafe_11_19),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_8_16t = parseInt(
		await ClientFunction(() => getRecordedColWidth(1))(),
	);
	let verifyVariable_cafe_9_17t = await ClientFunction(() =>
		jq(".z-column").eq(1).outerWidth(),
	)();
	let verifyVariable_cafe_10_18t = parseInt(
		await ClientFunction(() => getRecordedColWidth(1))(),
	);
	let verifyVariable_cafe_11_19t = await ClientFunction(() =>
		jq(".z-column").eq(1).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_8_16t),
		ztl.normalizeText(verifyVariable_cafe_11_19t),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_8_16tt = parseInt(
		await ClientFunction(() => getRecordedColWidth(2))(),
	);
	let verifyVariable_cafe_9_17tt = await ClientFunction(() =>
		jq(".z-column").eq(2).outerWidth(),
	)();
	let verifyVariable_cafe_10_18tt = parseInt(
		await ClientFunction(() => getRecordedColWidth(2))(),
	);
	let verifyVariable_cafe_11_19tt = await ClientFunction(() =>
		jq(".z-column").eq(2).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_8_16tt),
		ztl.normalizeText(verifyVariable_cafe_11_19tt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_8_16ttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(3))(),
	);
	let verifyVariable_cafe_9_17ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).outerWidth(),
	)();
	let verifyVariable_cafe_10_18ttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(3))(),
	);
	let verifyVariable_cafe_11_19ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_8_16ttt),
		ztl.normalizeText(verifyVariable_cafe_11_19ttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_8_16tttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(4))(),
	);
	let verifyVariable_cafe_9_17tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).outerWidth(),
	)();
	let verifyVariable_cafe_10_18tttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(4))(),
	);
	let verifyVariable_cafe_11_19tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_8_16tttt),
		ztl.normalizeText(verifyVariable_cafe_11_19tttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_8_16ttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(5))(),
	);
	let verifyVariable_cafe_9_17ttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).outerWidth(),
	)();
	let verifyVariable_cafe_10_18ttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(5))(),
	);
	let verifyVariable_cafe_11_19ttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_8_16ttttt),
		ztl.normalizeText(verifyVariable_cafe_11_19ttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_8_16tttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(6))(),
	);
	let verifyVariable_cafe_9_17tttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let verifyVariable_cafe_10_18tttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(6))(),
	);
	let verifyVariable_cafe_11_19tttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_8_16tttttt),
		ztl.normalizeText(verifyVariable_cafe_11_19tttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_8_16ttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(7))(),
	);
	let verifyVariable_cafe_9_17ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).outerWidth(),
	)();
	let verifyVariable_cafe_10_18ttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(7))(),
	);
	let verifyVariable_cafe_11_19ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_8_16ttttttt),
		ztl.normalizeText(verifyVariable_cafe_11_19ttttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_8_16tttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(8))(),
	);
	let verifyVariable_cafe_9_17tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).outerWidth(),
	)();
	let verifyVariable_cafe_10_18tttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(8))(),
	);
	let verifyVariable_cafe_11_19tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_8_16tttttttt),
		ztl.normalizeText(verifyVariable_cafe_11_19tttttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_8_16ttttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(9))(),
	);
	let verifyVariable_cafe_9_17ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).outerWidth(),
	)();
	let verifyVariable_cafe_10_18ttttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(9))(),
	);
	let verifyVariable_cafe_11_19ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_8_16ttttttttt),
		ztl.normalizeText(verifyVariable_cafe_11_19ttttttttt),
		ztl.normalizeText("1"),
	);
});
