import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3266TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3266.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3266TestCafe", async (t) => {
	await ztl.initTest(t);
	let gdw_cafe = await ClientFunction(() => jq("@grid").width())();
	let gdh_cafe = await ClientFunction(() => jq("@grid").height())();
	let ltw_cafe = await ClientFunction(() => jq("@listbox").width())();
	let lth_cafe = await ClientFunction(() => jq("@listbox").height())();
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq("@grid").parent().width(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq("@grid").parent().width(),
	)();
	await t
		.expect(ztl.normalizeText(verifyVariable_cafe_1_1))
		.eql(ztl.normalizeText(gdw_cafe + 2));
	let verifyVariable_cafe_2_2 = await ClientFunction(() =>
		jq("@grid").parent().height(),
	)();
	let verifyVariable_cafe_3_3 = await ClientFunction(() =>
		jq("@grid").parent().height(),
	)();
	await t
		.expect(ztl.normalizeText(verifyVariable_cafe_3_3))
		.eql(ztl.normalizeText(gdh_cafe + 2));
	let verifyVariable_cafe_4_4 = await ClientFunction(() =>
		jq("@listbox").parent().width(),
	)();
	let verifyVariable_cafe_5_5 = await ClientFunction(() =>
		jq("@listbox").parent().width(),
	)();
	await t
		.expect(ztl.normalizeText(verifyVariable_cafe_5_5))
		.eql(ztl.normalizeText(ltw_cafe + 2));
	let verifyVariable_cafe_6_6 = await ClientFunction(() =>
		jq("@listbox").parent().height(),
	)();
	let verifyVariable_cafe_7_7 = await ClientFunction(() =>
		jq("@listbox").parent().height(),
	)();
	await t
		.expect(ztl.normalizeText(verifyVariable_cafe_7_7))
		.eql(ztl.normalizeText(lth_cafe + 2));
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@grid").width())(),
			),
		)
		.eql(ztl.normalizeText(gdw_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@grid").height())(),
			),
		)
		.eql(ztl.normalizeText(gdh_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@listbox").width())(),
			),
		)
		.eql(ztl.normalizeText(ltw_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@listbox").height())(),
			),
		)
		.eql(ztl.normalizeText(lth_cafe));
});
