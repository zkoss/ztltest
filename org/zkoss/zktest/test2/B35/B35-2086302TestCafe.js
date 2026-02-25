import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2086302TestCafe`
	.page`http://localhost:8080/zktest/test2/B35-2086302.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B35-2086302TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.click(Selector(() => jq("$bt1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$bl1").is(":visible"))())
		.ok();
	let bl1h_cafe = await ClientFunction(() => jq("$bl1").height())();
	let bl1w_cafe = await ClientFunction(() => jq("$bl1").width())();
	await t.expect(bl1h_cafe == 500).ok();
	let bl2w_cafe = await ClientFunction(() => jq("$bl2").width())();
	let w2w_cafe = await ClientFunction(() =>
		jq("$w2").parent().outerWidth(),
	)();
	let verifyVariable_cafe_0_0 = parseInt(0.0);
	let verifyVariable_cafe_1_1 = parseInt(0.0);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(parseInt(bl2w_cafe * 0.25 + "")),
		ztl.normalizeText(w2w_cafe),
		ztl.normalizeText("1"),
	);
	let c2w_cafe_2 = await ClientFunction(() =>
		jq("$c2").parent().outerWidth(),
	)();
	let c2w_cafe = c2w_cafe_2 + 8;
	let verifyVariable_cafe_2_3 = parseInt(0.0);
	let verifyVariable_cafe_3_4 = parseInt(0.0);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(parseInt(bl2w_cafe * 0.25 + "")),
		ztl.normalizeText(c2w_cafe),
		ztl.normalizeText("1"),
	);
	let e2w_cafe = await ClientFunction(() =>
		jq(zk.Widget.$(jq("$bl2").find("@east")).$n("cave")).outerWidth(),
	)();
	let verifyVariable_cafe_4_5 = parseInt(0.0);
	let verifyVariable_cafe_5_6 = parseInt(0.0);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(parseInt(bl2w_cafe * 0.5 + "")),
		ztl.normalizeText(e2w_cafe),
		ztl.normalizeText("1"),
	);
	await t
		.expect(ztl.normalizeText("0px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl2").find("@east").css("border-top-width"),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("0px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl2").find("@east").css("border-left-width"),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("0px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl2").find("@east").css("border-right-width"),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("0px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl2").find("@east").css("border-bottom-width"),
				)(),
			),
		);
	let bl3w_cafe = await ClientFunction(() => jq("$bl3").width())();
	let w3w_cafe = await ClientFunction(() =>
		jq("$w3").parent().outerWidth(),
	)();
	let verifyVariable_cafe_6_7 = parseInt(0.0);
	let verifyVariable_cafe_7_8 = parseInt(0.0);
	await t
		.expect(ztl.normalizeText(w3w_cafe))
		.eql(ztl.normalizeText(parseInt(bl3w_cafe * 0.3 + "")));
	let c3w_cafe_9 = await ClientFunction(() =>
		jq(zk.Widget.$(jq("$bl3").find("@center")).$n("cave")).outerWidth(),
	)();
	let c3w_cafe = c3w_cafe_9 + 8;
	let verifyVariable_cafe_8_10 = parseInt(0.0);
	let verifyVariable_cafe_9_11 = parseInt(0.0);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(parseInt(bl3w_cafe * 0.4 + "")),
		ztl.normalizeText(c3w_cafe + 1),
		ztl.normalizeText("1"),
	);
	await t
		.expect(ztl.normalizeText("1px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl3").find(".z-center").css("border-top-width"),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("1px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl3").find(".z-center").css("border-left-width"),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("1px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl3").find(".z-center").css("border-right-width"),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("1px"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$bl3").find(".z-center").css("border-bottom-width"),
				)(),
			),
		);
	let e3w_cafe = await ClientFunction(() =>
		jq("$e3").parent().outerWidth(),
	)();
	let verifyVariable_cafe_10_12 = parseInt(0.0);
	let verifyVariable_cafe_11_13 = parseInt(0.0);
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(parseInt(bl3w_cafe * 0.3 + "")),
		ztl.normalizeText(e3w_cafe),
		ztl.normalizeText("1"),
	);
	let bl2h_cafe = await ClientFunction(() =>
		jq("$bl2").parent().outerHeight(),
	)();
	let bl3h_cafe_14 = await ClientFunction(() =>
		jq("$bl3").parent().outerHeight(),
	)();
	let bl3h_cafe = bl3h_cafe_14 + 8;
	let verifyVariable_cafe_12_15 = parseInt(0);
	let verifyVariable_cafe_13_16 = parseInt(0);
	await t
		.expect(ztl.normalizeText(parseInt(bl1h_cafe / 2)))
		.eql(ztl.normalizeText(bl2h_cafe));
	let verifyVariable_cafe_14_17 = parseInt(0);
	let verifyVariable_cafe_15_18 = parseInt(0);
	await t
		.expect(ztl.normalizeText(parseInt(bl1h_cafe / 2)))
		.eql(ztl.normalizeText(bl3h_cafe));
});
