import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3865TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3865.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3865TestCafe", async (t) => {
	await ztl.initTest(t);
	let widthToMinus_cafe_0 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(0).find(".inner").css("margin-left"),
		)(),
	);
	let widthToMinus_cafe_1 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(0).find(".inner").css("margin-right"),
		)(),
	);
	let widthToMinus_cafe = widthToMinus_cafe_0 + widthToMinus_cafe_1;
	let verifyVariable_cafe_0_2 = await ClientFunction(() =>
		jq(".outer").eq(0).find(".inner").outerWidth(),
	)();
	let verifyVariable_cafe_1_3 = await ClientFunction(() =>
		jq(".outer").eq(0).innerWidth(),
	)();
	let verifyVariable_cafe_2_4 = await ClientFunction(() =>
		jq(".outer").eq(0).find(".inner").outerWidth(),
	)();
	let verifyVariable_cafe_3_5 = await ClientFunction(() =>
		jq(".outer").eq(0).innerWidth(),
	)();
	await t
		.expect(ztl.normalizeText(verifyVariable_cafe_3_5 - widthToMinus_cafe))
		.eql(ztl.normalizeText(verifyVariable_cafe_0_2));
	let widthToMinus_cafe_6 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(1).find(".inner").css("margin-left"),
		)(),
	);
	let widthToMinus_cafe_7 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(1).find(".inner").css("margin-right"),
		)(),
	);
	widthToMinus_cafe = widthToMinus_cafe_6 + widthToMinus_cafe_7;
	let verifyVariable_cafe_4_8 = await ClientFunction(() =>
		jq(".outer").eq(1).innerWidth(),
	)();
	let verifyVariable_cafe_5_9 = await ClientFunction(() =>
		jq(".outer").eq(1).find(".inner").outerWidth(),
	)();
	let verifyVariable_cafe_6_10 = await ClientFunction(() =>
		jq(".outer").eq(1).innerWidth(),
	)();
	let verifyVariable_cafe_7_11 = await ClientFunction(() =>
		jq(".outer").eq(1).find(".inner").outerWidth(),
	)();
	await t
		.expect(ztl.normalizeText(verifyVariable_cafe_6_10 - widthToMinus_cafe))
		.eql(ztl.normalizeText(verifyVariable_cafe_5_9));
	let heightToMinus_cafe_12 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(2).find(".inner").css("margin-top"),
		)(),
	);
	let heightToMinus_cafe_13 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(2).find(".inner").css("margin-bottom"),
		)(),
	);
	let heightToMinus_cafe = heightToMinus_cafe_12 + heightToMinus_cafe_13;
	let verifyVariable_cafe_8_14 = await ClientFunction(() =>
		jq(".outer").eq(2).find(".inner").outerHeight(),
	)();
	let verifyVariable_cafe_9_15 = await ClientFunction(() =>
		jq(".outer").eq(2).innerHeight(),
	)();
	let verifyVariable_cafe_10_16 = await ClientFunction(() =>
		jq(".outer").eq(2).find(".inner").outerHeight(),
	)();
	let verifyVariable_cafe_11_17 = await ClientFunction(() =>
		jq(".outer").eq(2).innerHeight(),
	)();
	await t
		.expect(
			ztl.normalizeText(verifyVariable_cafe_11_17 - heightToMinus_cafe),
		)
		.eql(ztl.normalizeText(verifyVariable_cafe_8_14));
	let heightToMinus_cafe_18 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(3).find(".inner").css("margin-top"),
		)(),
	);
	let heightToMinus_cafe_19 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(3).find(".inner").css("margin-bottom"),
		)(),
	);
	heightToMinus_cafe = heightToMinus_cafe_18 + heightToMinus_cafe_19;
	let verifyVariable_cafe_12_20 = await ClientFunction(() =>
		jq(".outer").eq(3).innerHeight(),
	)();
	let verifyVariable_cafe_13_21 = await ClientFunction(() =>
		jq(".outer").eq(3).find(".inner").outerHeight(),
	)();
	let verifyVariable_cafe_14_22 = await ClientFunction(() =>
		jq(".outer").eq(3).innerHeight(),
	)();
	let verifyVariable_cafe_15_23 = await ClientFunction(() =>
		jq(".outer").eq(3).find(".inner").outerHeight(),
	)();
	await t
		.expect(
			ztl.normalizeText(verifyVariable_cafe_14_22 - heightToMinus_cafe),
		)
		.eql(ztl.normalizeText(verifyVariable_cafe_13_21));
	let widthToMinus_cafe_24 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(4).find(".inner").css("margin-right"),
		)(),
	);
	let widthToMinus_cafe_25 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(4).find(".inner").css("margin-left"),
		)(),
	);
	widthToMinus_cafe = widthToMinus_cafe_25 + widthToMinus_cafe_24;
	let heightToMinus_cafe_26 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(4).find(".inner").css("margin-top"),
		)(),
	);
	let heightToMinus_cafe_27 = parseInt(
		await ClientFunction(() =>
			jq(".outer").eq(4).find(".inner").css("margin-bottom"),
		)(),
	);
	heightToMinus_cafe = heightToMinus_cafe_26 + heightToMinus_cafe_27;
	let verifyVariable_cafe_16_28 = await ClientFunction(() =>
		jq(".outer").eq(4).find(".inner").width(),
	)();
	let verifyVariable_cafe_17_29 = await ClientFunction(() =>
		jq(".outer").eq(4).width(),
	)();
	let verifyVariable_cafe_18_30 = await ClientFunction(() =>
		jq(".outer").eq(4).find(".inner").width(),
	)();
	let verifyVariable_cafe_19_31 = await ClientFunction(() =>
		jq(".outer").eq(4).width(),
	)();
	await t
		.expect(
			ztl.normalizeText(verifyVariable_cafe_19_31 - widthToMinus_cafe),
		)
		.eql(ztl.normalizeText(verifyVariable_cafe_16_28));
	let verifyVariable_cafe_20_32 = await ClientFunction(() =>
		jq(".outer").eq(4).find(".inner").outerHeight(),
	)();
	let verifyVariable_cafe_21_33 = await ClientFunction(() =>
		jq(".outer").eq(4).innerHeight(),
	)();
	let verifyVariable_cafe_22_34 = await ClientFunction(() =>
		jq(".outer").eq(4).find(".inner").outerHeight(),
	)();
	let verifyVariable_cafe_23_35 = await ClientFunction(() =>
		jq(".outer").eq(4).innerHeight(),
	)();
	await t
		.expect(
			ztl.normalizeText(verifyVariable_cafe_23_35 - heightToMinus_cafe),
		)
		.eql(ztl.normalizeText(verifyVariable_cafe_20_32));
});
