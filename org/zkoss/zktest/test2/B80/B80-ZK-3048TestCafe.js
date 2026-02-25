import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3048TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3048.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3048TestCafe", async (t) => {
	await ztl.initTest(t);
	await ClientFunction(() => {
		jq(".z-listbox-body")[0].scrollTop = 1000;
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-listbox-body").eq(0).offset().top,
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(0).outerHeight(),
	)();
	let verifyVariable_cafe_2_2 = await ClientFunction(
		() =>
			jq(".z-listbox-body").eq(0).find(".z-listitem").last().offset().top,
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(0).find(".z-listitem").last().outerHeight(),
	)();
	let verifyVariable_cafe_4_4 = await ClientFunction(
		() => jq(".z-listbox-body").eq(0).offset().top,
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(0).outerHeight(),
	)();
	let verifyVariable_cafe_6_6 = await ClientFunction(
		() =>
			jq(".z-listbox-body").eq(0).find(".z-listitem").last().offset().top,
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(0).find(".z-listitem").last().outerHeight(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_2_2 + verifyVariable_cafe_3_3),
		ztl.normalizeText(verifyVariable_cafe_4_4 + verifyVariable_cafe_5_5),
		ztl.normalizeText("1"),
	);
	await ClientFunction(() => {
		jq(".z-listbox-body")[1].scrollLeft = 1000;
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_8_8 = await ClientFunction(
		() => jq(".z-listbox-body").eq(1).offset().left,
	)();
	let verifyVariable_cafe_9_9 = await ClientFunction(
		() =>
			jq(".z-listbox-body").eq(1).find(".z-listitem").first().offset()
				.left,
	)();
	let verifyVariable_cafe_10_10 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(1).outerWidth(),
	)();
	let verifyVariable_cafe_11_11 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(1).find(".z-listitem").first().outerWidth(),
	)();
	let verifyVariable_cafe_12_12 = await ClientFunction(
		() => jq(".z-listbox-body").eq(1).offset().left,
	)();
	let verifyVariable_cafe_13_13 = await ClientFunction(
		() =>
			jq(".z-listbox-body").eq(1).find(".z-listitem").first().offset()
				.left,
	)();
	let verifyVariable_cafe_14_14 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(1).outerWidth(),
	)();
	let verifyVariable_cafe_15_15 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(1).find(".z-listitem").first().outerWidth(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(verifyVariable_cafe_9_9 + verifyVariable_cafe_11_11),
		ztl.normalizeText(
			verifyVariable_cafe_12_12 + verifyVariable_cafe_14_14,
		),
		ztl.normalizeText("1"),
	);
	await ClientFunction(() => {
		jq(".z-listbox-body")[2].scrollTop = 1000;
	})();
	await ClientFunction(() => {
		jq(".z-listbox-body")[2].scrollLeft = 1000;
	})();
	await ztl.waitResponse(t);
	let verifyVariable_cafe_16_16 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(2).outerHeight(),
	)();
	let verifyVariable_cafe_17_17 = await ClientFunction(
		() => jq(".z-listbox-body").eq(2).offset().top,
	)();
	let verifyVariable_cafe_18_18 = await ClientFunction(
		() =>
			jq(".z-listbox-body").eq(2).find(".z-listitem").last().offset().top,
	)();
	let verifyVariable_cafe_19_19 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(2).find(".z-listitem").last().outerHeight(),
	)();
	let verifyVariable_cafe_20_20 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(2).outerHeight(),
	)();
	let verifyVariable_cafe_21_21 = await ClientFunction(
		() => jq(".z-listbox-body").eq(2).offset().top,
	)();
	let verifyVariable_cafe_22_22 = await ClientFunction(
		() =>
			jq(".z-listbox-body").eq(2).find(".z-listitem").last().offset().top,
	)();
	let verifyVariable_cafe_23_23 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(2).find(".z-listitem").last().outerHeight(),
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_18_18 + verifyVariable_cafe_19_19,
		),
		ztl.normalizeText(
			verifyVariable_cafe_21_21 + verifyVariable_cafe_20_20,
		),
		ztl.normalizeText("1"),
	);
	let verifyVariable_cafe_24_24 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(2).find(".z-listitem").last().outerWidth(),
	)();
	let verifyVariable_cafe_25_25 = await ClientFunction(
		() => jq(".z-listbox-body").eq(2).offset().left,
	)();
	let verifyVariable_cafe_26_26 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(2).outerWidth(),
	)();
	let verifyVariable_cafe_27_27 = await ClientFunction(
		() =>
			jq(".z-listbox-body").eq(2).find(".z-listitem").last().offset()
				.left,
	)();
	let verifyVariable_cafe_28_28 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(2).find(".z-listitem").last().outerWidth(),
	)();
	let verifyVariable_cafe_29_29 = await ClientFunction(
		() => jq(".z-listbox-body").eq(2).offset().left,
	)();
	let verifyVariable_cafe_30_30 = await ClientFunction(() =>
		jq(".z-listbox-body").eq(2).outerWidth(),
	)();
	let verifyVariable_cafe_31_31 = await ClientFunction(
		() =>
			jq(".z-listbox-body").eq(2).find(".z-listitem").last().offset()
				.left,
	)();
	await ztl.verifyTolerant(
		t,
		ztl.normalizeText(
			verifyVariable_cafe_27_27 + verifyVariable_cafe_24_24,
		),
		ztl.normalizeText(
			verifyVariable_cafe_29_29 + verifyVariable_cafe_30_30,
		),
		ztl.normalizeText("1"),
	);
});
