import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B95-ZK-4322TestCafe`
	.page`http://localhost:8080/zktest/test2/B95-ZK-4322.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B95-ZK-4322TestCafe", async (t) => {
	await ztl.initTest(t);
	if (
		await ztl.isBrowserIgnored("chrome,ff,ie11,ie10,ie9,edge,ios,android")
	) {
		console.log(
			"This issue is ignored in current browser! (chrome,ff,ie11,ie10,ie9,edge,ios,android)",
		);
		return;
	}
	let width1_cafe = await ClientFunction(() =>
		jq("@listbox:eq(0)").find(".z-listbox-body").height(),
	)();
	let width2_cafe = await ClientFunction(() =>
		jq("@listbox:eq(0)").find(".z-listbox-body").height(),
	)();
	await t.click(Selector(() => jq("@button:eq(0)")[0]));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox:eq(0)").find(".z-listbox-body").height(),
				)(),
			),
		)
		.eql(ztl.normalizeText(width1_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox:eq(1)").find(".z-listbox-body").height(),
				)(),
			),
		)
		.eql(ztl.normalizeText(width2_cafe));
	await t.click(Selector(() => jq("@button:eq(1)")[0]));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox:eq(0)").find(".z-listbox-body").height(),
				)(),
			),
		)
		.eql(ztl.normalizeText(width1_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox:eq(1)").find(".z-listbox-body").height(),
				)(),
			),
		)
		.eql(ztl.normalizeText(width2_cafe));
	await t.click(Selector(() => jq("@button:eq(2)")[0]));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox:eq(0)").find(".z-listbox-body").height(),
				)(),
			),
		)
		.eql(ztl.normalizeText(width1_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("@listbox:eq(1)").find(".z-listbox-body").height(),
				)(),
			),
		)
		.eql(ztl.normalizeText(width2_cafe));
});
