import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-2772TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-2772.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-2772TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		recordColsWidth();
	})();
	await ClientFunction(() => {
		zk.Widget.$(".z-frozen").$n("scrollX").scrollLeft =
			zk.Widget.$(".z-frozen").$n("scrollX").scrollWidth;
	})();
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-column").last()[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-column").eq(0).outerWidth(),
	)();
	let verifyVariable_cafe_1_1 = parseInt(
		await ClientFunction(() => getRecordedColWidth(0))(),
	);
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(".z-column").eq(0).outerWidth(),
	)();
	let verifyVariable_cafe_3_3 = parseInt(
		await ClientFunction(() => getRecordedColWidth(0))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1),
		ztl.normalizeText(verifyVariable_cafe_2_2),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(".z-column").eq(1).outerWidth(),
	)();
	let verifyVariable_cafe_1_1t = parseInt(
		await ClientFunction(() => getRecordedColWidth(1))(),
	);
	let verifyVariable_cafe_2_2t = await ClientFunction(() =>
		jq(".z-column").eq(1).outerWidth(),
	)();
	let verifyVariable_cafe_3_3t = parseInt(
		await ClientFunction(() => getRecordedColWidth(1))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1t),
		ztl.normalizeText(verifyVariable_cafe_2_2t),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq(".z-column").eq(2).outerWidth(),
	)();
	let verifyVariable_cafe_1_1tt = parseInt(
		await ClientFunction(() => getRecordedColWidth(2))(),
	);
	let verifyVariable_cafe_2_2tt = await ClientFunction(() =>
		jq(".z-column").eq(2).outerWidth(),
	)();
	let verifyVariable_cafe_3_3tt = parseInt(
		await ClientFunction(() => getRecordedColWidth(2))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1tt),
		ztl.normalizeText(verifyVariable_cafe_2_2tt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).outerWidth(),
	)();
	let verifyVariable_cafe_1_1ttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(3))(),
	);
	let verifyVariable_cafe_2_2ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).outerWidth(),
	)();
	let verifyVariable_cafe_3_3ttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(3))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1ttt),
		ztl.normalizeText(verifyVariable_cafe_2_2ttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).outerWidth(),
	)();
	let verifyVariable_cafe_1_1tttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(4))(),
	);
	let verifyVariable_cafe_2_2tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).outerWidth(),
	)();
	let verifyVariable_cafe_3_3tttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(4))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1tttt),
		ztl.normalizeText(verifyVariable_cafe_2_2tttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).outerWidth(),
	)();
	let verifyVariable_cafe_1_1ttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(9))(),
	);
	let verifyVariable_cafe_2_2ttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).outerWidth(),
	)();
	let verifyVariable_cafe_3_3ttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(9))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_1_1ttttt),
		ztl.normalizeText(verifyVariable_cafe_2_2ttttt),
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
	let actionVariable_cafe_0_4 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let actionVariable_cafe_1_5 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let actionVariable_cafe_2_6 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerHeight(),
	)();
	let actionVariable_cafe_3_7 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerHeight(),
	)();
	let actionVariable_cafe_4_8 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let actionVariable_cafe_5_9 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let actionVariable_cafe_6_10 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerHeight(),
	)();
	let actionVariable_cafe_7_11 = await ClientFunction(() =>
		jq(".z-column").eq(6).outerHeight(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_4_8 - 100 + "," + actionVariable_cafe_6_10 / 2,
	);

	let cafeCoord_2 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_0_4 + "," + actionVariable_cafe_2_6 / 2,
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
	await t.click(Selector(() => jq(".z-column").eq(6)[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_4_12 = await ClientFunction(() =>
		jq(".z-column").eq(0).outerWidth(),
	)();
	let verifyVariable_cafe_5_13 = parseInt(
		await ClientFunction(() => getRecordedColWidth(0))(),
	);
	let verifyVariable_cafe_6_14 = await ClientFunction(() =>
		jq(".z-column").eq(0).outerWidth(),
	)();
	let verifyVariable_cafe_7_15 = parseInt(
		await ClientFunction(() => getRecordedColWidth(0))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_5_13),
		ztl.normalizeText(verifyVariable_cafe_6_14),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_12t = await ClientFunction(() =>
		jq(".z-column").eq(1).outerWidth(),
	)();
	let verifyVariable_cafe_5_13t = parseInt(
		await ClientFunction(() => getRecordedColWidth(1))(),
	);
	let verifyVariable_cafe_6_14t = await ClientFunction(() =>
		jq(".z-column").eq(1).outerWidth(),
	)();
	let verifyVariable_cafe_7_15t = parseInt(
		await ClientFunction(() => getRecordedColWidth(1))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_5_13t),
		ztl.normalizeText(verifyVariable_cafe_6_14t),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_12tt = await ClientFunction(() =>
		jq(".z-column").eq(2).outerWidth(),
	)();
	let verifyVariable_cafe_5_13tt = parseInt(
		await ClientFunction(() => getRecordedColWidth(2))(),
	);
	let verifyVariable_cafe_6_14tt = await ClientFunction(() =>
		jq(".z-column").eq(2).outerWidth(),
	)();
	let verifyVariable_cafe_7_15tt = parseInt(
		await ClientFunction(() => getRecordedColWidth(2))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_5_13tt),
		ztl.normalizeText(verifyVariable_cafe_6_14tt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_12ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).outerWidth(),
	)();
	let verifyVariable_cafe_5_13ttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(3))(),
	);
	let verifyVariable_cafe_6_14ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).outerWidth(),
	)();
	let verifyVariable_cafe_7_15ttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(3))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_5_13ttt),
		ztl.normalizeText(verifyVariable_cafe_6_14ttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_12tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).outerWidth(),
	)();
	let verifyVariable_cafe_5_13tttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(4))(),
	);
	let verifyVariable_cafe_6_14tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).outerWidth(),
	)();
	let verifyVariable_cafe_7_15tttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(4))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_5_13tttt),
		ztl.normalizeText(verifyVariable_cafe_6_14tttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_12ttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).outerWidth(),
	)();
	let verifyVariable_cafe_5_13ttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(5))(),
	);
	let verifyVariable_cafe_6_14ttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).outerWidth(),
	)();
	let verifyVariable_cafe_7_15ttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(5))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_5_13ttttt),
		ztl.normalizeText(verifyVariable_cafe_6_14ttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_12tttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let verifyVariable_cafe_5_13tttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(6))(),
	);
	let verifyVariable_cafe_6_14tttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).outerWidth(),
	)();
	let verifyVariable_cafe_7_15tttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(6))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_5_13tttttt),
		ztl.normalizeText(verifyVariable_cafe_6_14tttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_12ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).outerWidth(),
	)();
	let verifyVariable_cafe_5_13ttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(7))(),
	);
	let verifyVariable_cafe_6_14ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).outerWidth(),
	)();
	let verifyVariable_cafe_7_15ttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(7))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_5_13ttttttt),
		ztl.normalizeText(verifyVariable_cafe_6_14ttttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_12tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).outerWidth(),
	)();
	let verifyVariable_cafe_5_13tttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(8))(),
	);
	let verifyVariable_cafe_6_14tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).outerWidth(),
	)();
	let verifyVariable_cafe_7_15tttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(8))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_5_13tttttttt),
		ztl.normalizeText(verifyVariable_cafe_6_14tttttttt),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_4_12ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).outerWidth(),
	)();
	let verifyVariable_cafe_5_13ttttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(9))(),
	);
	let verifyVariable_cafe_6_14ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).outerWidth(),
	)();
	let verifyVariable_cafe_7_15ttttttttt = parseInt(
		await ClientFunction(() => getRecordedColWidth(9))(),
	);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_5_13ttttttttt),
		ztl.normalizeText(verifyVariable_cafe_6_14ttttttttt),
		ztl.normalizeText("1"),
	);
});
