import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2866TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2866.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2866TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(1);
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_6_6 = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2),
		ztl.normalizeText(
			verifyVariable_cafe_5_5 +
				verifyVariable_cafe_7_7 +
				verifyVariable_cafe_4_4,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_8_8 = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_9_9 = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_10_10 = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_11_11 = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	let verifyVariable_cafe_12_12 = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_13_13 = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_14_14 = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_15_15 = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9),
		ztl.normalizeText(
			verifyVariable_cafe_15_15 +
				verifyVariable_cafe_12_12 +
				verifyVariable_cafe_14_14,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_16_16 = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_17_17 = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_18_18 = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_19_19 = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	let verifyVariable_cafe_20_20 = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_21_21 = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_22_22 = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_23_23 = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_19_19),
		ztl.normalizeText(
			verifyVariable_cafe_22_22 +
				verifyVariable_cafe_20_20 +
				verifyVariable_cafe_21_21,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_24_24 = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_25_25 = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_26_26 = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_27_27 = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	let verifyVariable_cafe_28_28 = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_29_29 = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_30_30 = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_31_31 = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_27_27),
		ztl.normalizeText(
			verifyVariable_cafe_29_29 +
				verifyVariable_cafe_30_30 +
				verifyVariable_cafe_28_28,
		),
		ztl.normalizeText("3"),
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(2);
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1t = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_2_2t = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3t = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let verifyVariable_cafe_4_4t = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_5_5t = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_6_6t = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_7_7t = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2t),
		ztl.normalizeText(
			verifyVariable_cafe_5_5t +
				verifyVariable_cafe_7_7t +
				verifyVariable_cafe_4_4t,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_8_8t = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_9_9t = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_10_10t = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_11_11t = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	let verifyVariable_cafe_12_12t = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_13_13t = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_14_14t = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_15_15t = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9t),
		ztl.normalizeText(
			verifyVariable_cafe_15_15t +
				verifyVariable_cafe_12_12t +
				verifyVariable_cafe_14_14t,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_16_16t = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_17_17t = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_18_18t = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_19_19t = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	let verifyVariable_cafe_20_20t = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_21_21t = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_22_22t = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_23_23t = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_19_19t),
		ztl.normalizeText(
			verifyVariable_cafe_22_22t +
				verifyVariable_cafe_20_20t +
				verifyVariable_cafe_21_21t,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_24_24t = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_25_25t = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_26_26t = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_27_27t = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	let verifyVariable_cafe_28_28t = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_29_29t = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_30_30t = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_31_31t = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_27_27t),
		ztl.normalizeText(
			verifyVariable_cafe_29_29t +
				verifyVariable_cafe_30_30t +
				verifyVariable_cafe_28_28t,
		),
		ztl.normalizeText("3"),
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(3);
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1tt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_2_2tt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3tt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let verifyVariable_cafe_4_4tt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_5_5tt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_6_6tt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_7_7tt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tt),
		ztl.normalizeText(
			verifyVariable_cafe_5_5tt +
				verifyVariable_cafe_7_7tt +
				verifyVariable_cafe_4_4tt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_8_8tt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_9_9tt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_10_10tt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_11_11tt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	let verifyVariable_cafe_12_12tt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_13_13tt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_14_14tt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_15_15tt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9tt),
		ztl.normalizeText(
			verifyVariable_cafe_15_15tt +
				verifyVariable_cafe_12_12tt +
				verifyVariable_cafe_14_14tt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_16_16tt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_17_17tt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_18_18tt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_19_19tt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	let verifyVariable_cafe_20_20tt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_21_21tt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_22_22tt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_23_23tt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_19_19tt),
		ztl.normalizeText(
			verifyVariable_cafe_22_22tt +
				verifyVariable_cafe_20_20tt +
				verifyVariable_cafe_21_21tt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_24_24tt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_25_25tt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_26_26tt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_27_27tt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	let verifyVariable_cafe_28_28tt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_29_29tt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_30_30tt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_31_31tt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_27_27tt),
		ztl.normalizeText(
			verifyVariable_cafe_29_29tt +
				verifyVariable_cafe_30_30tt +
				verifyVariable_cafe_28_28tt,
		),
		ztl.normalizeText("3"),
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(4);
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1ttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_2_2ttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3ttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let verifyVariable_cafe_4_4ttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_5_5ttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_6_6ttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_7_7ttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttt),
		ztl.normalizeText(
			verifyVariable_cafe_5_5ttt +
				verifyVariable_cafe_7_7ttt +
				verifyVariable_cafe_4_4ttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_8_8ttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_9_9ttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_10_10ttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_11_11ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	let verifyVariable_cafe_12_12ttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_13_13ttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_14_14ttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_15_15ttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9ttt),
		ztl.normalizeText(
			verifyVariable_cafe_15_15ttt +
				verifyVariable_cafe_12_12ttt +
				verifyVariable_cafe_14_14ttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_16_16ttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_17_17ttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_18_18ttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_19_19ttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	let verifyVariable_cafe_20_20ttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_21_21ttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_22_22ttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_23_23ttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_19_19ttt),
		ztl.normalizeText(
			verifyVariable_cafe_22_22ttt +
				verifyVariable_cafe_20_20ttt +
				verifyVariable_cafe_21_21ttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_24_24ttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_25_25ttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_26_26ttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_27_27ttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	let verifyVariable_cafe_28_28ttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_29_29ttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_30_30ttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_31_31ttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_27_27ttt),
		ztl.normalizeText(
			verifyVariable_cafe_29_29ttt +
				verifyVariable_cafe_30_30ttt +
				verifyVariable_cafe_28_28ttt,
		),
		ztl.normalizeText("3"),
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(5);
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1tttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_2_2tttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3tttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let verifyVariable_cafe_4_4tttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_5_5tttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_6_6tttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_7_7tttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttt),
		ztl.normalizeText(
			verifyVariable_cafe_5_5tttt +
				verifyVariable_cafe_7_7tttt +
				verifyVariable_cafe_4_4tttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_8_8tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_9_9tttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_10_10tttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_11_11tttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	let verifyVariable_cafe_12_12tttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_13_13tttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_14_14tttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_15_15tttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9tttt),
		ztl.normalizeText(
			verifyVariable_cafe_15_15tttt +
				verifyVariable_cafe_12_12tttt +
				verifyVariable_cafe_14_14tttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_16_16tttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_17_17tttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_18_18tttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_19_19tttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	let verifyVariable_cafe_20_20tttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_21_21tttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_22_22tttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_23_23tttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_19_19tttt),
		ztl.normalizeText(
			verifyVariable_cafe_22_22tttt +
				verifyVariable_cafe_20_20tttt +
				verifyVariable_cafe_21_21tttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_24_24tttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_25_25tttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_26_26tttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_27_27tttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	let verifyVariable_cafe_28_28tttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_29_29tttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_30_30tttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_31_31tttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_27_27tttt),
		ztl.normalizeText(
			verifyVariable_cafe_29_29tttt +
				verifyVariable_cafe_30_30tttt +
				verifyVariable_cafe_28_28tttt,
		),
		ztl.normalizeText("3"),
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(6);
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1ttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_2_2ttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3ttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let verifyVariable_cafe_4_4ttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_5_5ttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_6_6ttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_7_7ttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttt),
		ztl.normalizeText(
			verifyVariable_cafe_5_5ttttt +
				verifyVariable_cafe_7_7ttttt +
				verifyVariable_cafe_4_4ttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_8_8ttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_9_9ttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_10_10ttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_11_11ttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	let verifyVariable_cafe_12_12ttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_13_13ttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_14_14ttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_15_15ttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9ttttt),
		ztl.normalizeText(
			verifyVariable_cafe_15_15ttttt +
				verifyVariable_cafe_12_12ttttt +
				verifyVariable_cafe_14_14ttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_16_16ttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_17_17ttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_18_18ttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_19_19ttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	let verifyVariable_cafe_20_20ttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_21_21ttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_22_22ttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_23_23ttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_19_19ttttt),
		ztl.normalizeText(
			verifyVariable_cafe_22_22ttttt +
				verifyVariable_cafe_20_20ttttt +
				verifyVariable_cafe_21_21ttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_24_24ttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_25_25ttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_26_26ttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_27_27ttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	let verifyVariable_cafe_28_28ttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_29_29ttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_30_30ttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_31_31ttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_27_27ttttt),
		ztl.normalizeText(
			verifyVariable_cafe_29_29ttttt +
				verifyVariable_cafe_30_30ttttt +
				verifyVariable_cafe_28_28ttttt,
		),
		ztl.normalizeText("3"),
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(7);
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1tttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_2_2tttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3tttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let verifyVariable_cafe_4_4tttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_5_5tttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_6_6tttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_7_7tttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttt),
		ztl.normalizeText(
			verifyVariable_cafe_5_5tttttt +
				verifyVariable_cafe_7_7tttttt +
				verifyVariable_cafe_4_4tttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_8_8tttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_9_9tttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_10_10tttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_11_11tttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	let verifyVariable_cafe_12_12tttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_13_13tttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_14_14tttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_15_15tttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9tttttt),
		ztl.normalizeText(
			verifyVariable_cafe_15_15tttttt +
				verifyVariable_cafe_12_12tttttt +
				verifyVariable_cafe_14_14tttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_16_16tttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_17_17tttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_18_18tttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_19_19tttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	let verifyVariable_cafe_20_20tttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_21_21tttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_22_22tttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_23_23tttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_19_19tttttt),
		ztl.normalizeText(
			verifyVariable_cafe_22_22tttttt +
				verifyVariable_cafe_20_20tttttt +
				verifyVariable_cafe_21_21tttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_24_24tttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_25_25tttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_26_26tttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_27_27tttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	let verifyVariable_cafe_28_28tttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_29_29tttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_30_30tttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_31_31tttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_27_27tttttt),
		ztl.normalizeText(
			verifyVariable_cafe_29_29tttttt +
				verifyVariable_cafe_30_30tttttt +
				verifyVariable_cafe_28_28tttttt,
		),
		ztl.normalizeText("3"),
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(8);
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_2_2ttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let verifyVariable_cafe_4_4ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_5_5ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_6_6ttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_7_7ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_5_5ttttttt +
				verifyVariable_cafe_7_7ttttttt +
				verifyVariable_cafe_4_4ttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_8_8ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_9_9ttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_10_10ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_11_11ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	let verifyVariable_cafe_12_12ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_13_13ttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_14_14ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_15_15ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9ttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_15_15ttttttt +
				verifyVariable_cafe_12_12ttttttt +
				verifyVariable_cafe_14_14ttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_16_16ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_17_17ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_18_18ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_19_19ttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	let verifyVariable_cafe_20_20ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_21_21ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_22_22ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_23_23ttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_19_19ttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_22_22ttttttt +
				verifyVariable_cafe_20_20ttttttt +
				verifyVariable_cafe_21_21ttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_24_24ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_25_25ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_26_26ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_27_27ttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	let verifyVariable_cafe_28_28ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_29_29ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_30_30ttttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_31_31ttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_27_27ttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_29_29ttttttt +
				verifyVariable_cafe_30_30ttttttt +
				verifyVariable_cafe_28_28ttttttt,
		),
		ztl.normalizeText("3"),
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(9);
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_2_2tttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let verifyVariable_cafe_4_4tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_5_5tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_6_6tttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_7_7tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_5_5tttttttt +
				verifyVariable_cafe_7_7tttttttt +
				verifyVariable_cafe_4_4tttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_8_8tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_9_9tttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_10_10tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_11_11tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	let verifyVariable_cafe_12_12tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_13_13tttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_14_14tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_15_15tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9tttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_15_15tttttttt +
				verifyVariable_cafe_12_12tttttttt +
				verifyVariable_cafe_14_14tttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_16_16tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_17_17tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_18_18tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_19_19tttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	let verifyVariable_cafe_20_20tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_21_21tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_22_22tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_23_23tttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_19_19tttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_22_22tttttttt +
				verifyVariable_cafe_20_20tttttttt +
				verifyVariable_cafe_21_21tttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_24_24tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_25_25tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_26_26tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_27_27tttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	let verifyVariable_cafe_28_28tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_29_29tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_30_30tttttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_31_31tttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_27_27tttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_29_29tttttttt +
				verifyVariable_cafe_30_30tttttttt +
				verifyVariable_cafe_28_28tttttttt,
		),
		ztl.normalizeText("3"),
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(10);
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_2_2ttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let verifyVariable_cafe_4_4ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_5_5ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_6_6ttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_7_7ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2ttttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_5_5ttttttttt +
				verifyVariable_cafe_7_7ttttttttt +
				verifyVariable_cafe_4_4ttttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_8_8ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_9_9ttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_10_10ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_11_11ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	let verifyVariable_cafe_12_12ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_13_13ttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_14_14ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_15_15ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9ttttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_15_15ttttttttt +
				verifyVariable_cafe_12_12ttttttttt +
				verifyVariable_cafe_14_14ttttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_16_16ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_17_17ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_18_18ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_19_19ttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	let verifyVariable_cafe_20_20ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_21_21ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_22_22ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_23_23ttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_19_19ttttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_22_22ttttttttt +
				verifyVariable_cafe_20_20ttttttttt +
				verifyVariable_cafe_21_21ttttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_24_24ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_25_25ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_26_26ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_27_27ttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	let verifyVariable_cafe_28_28ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_29_29ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_30_30ttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_31_31ttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_27_27ttttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_29_29ttttttttt +
				verifyVariable_cafe_30_30ttttttttt +
				verifyVariable_cafe_28_28ttttttttt,
		),
		ztl.normalizeText("3"),
	);
	await ClientFunction(() => {
		zk.Widget.$(jq(jq("@grid"))).frozen._doScrollNow(11);
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_1_1tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_2_2tttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_3_3tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	let verifyVariable_cafe_4_4tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(2).width(),
	)();
	let verifyVariable_cafe_5_5tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let verifyVariable_cafe_6_6tttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(2).width(),
	)();
	let verifyVariable_cafe_7_7tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(1).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2tttttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_5_5tttttttttt +
				verifyVariable_cafe_7_7tttttttttt +
				verifyVariable_cafe_4_4tttttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_8_8tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_9_9tttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_10_10tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_11_11tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	let verifyVariable_cafe_12_12tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(4).width(),
	)();
	let verifyVariable_cafe_13_13tttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(3).width(),
	)();
	let verifyVariable_cafe_14_14tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(5).width(),
	)();
	let verifyVariable_cafe_15_15tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(3).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9tttttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_15_15tttttttttt +
				verifyVariable_cafe_12_12tttttttttt +
				verifyVariable_cafe_14_14tttttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_16_16tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_17_17tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_18_18tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_19_19tttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	let verifyVariable_cafe_20_20tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(7).width(),
	)();
	let verifyVariable_cafe_21_21tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(8).width(),
	)();
	let verifyVariable_cafe_22_22tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(6).width(),
	)();
	let verifyVariable_cafe_23_23tttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(4).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_19_19tttttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_22_22tttttttttt +
				verifyVariable_cafe_20_20tttttttttt +
				verifyVariable_cafe_21_21tttttttttt,
		),
		ztl.normalizeText("3"),
	);
	let verifyVariable_cafe_24_24tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_25_25tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_26_26tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_27_27tttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	let verifyVariable_cafe_28_28tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(11).width(),
	)();
	let verifyVariable_cafe_29_29tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(9).width(),
	)();
	let verifyVariable_cafe_30_30tttttttttt = await ClientFunction(() =>
		jq(".z-column").eq(10).width(),
	)();
	let verifyVariable_cafe_31_31tttttttttt = await ClientFunction(() =>
		jq(".z-auxheader").eq(5).width(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_27_27tttttttttt),
		ztl.normalizeText(
			verifyVariable_cafe_29_29tttttttttt +
				verifyVariable_cafe_30_30tttttttttt +
				verifyVariable_cafe_28_28tttttttttt,
		),
		ztl.normalizeText("3"),
	);
});
