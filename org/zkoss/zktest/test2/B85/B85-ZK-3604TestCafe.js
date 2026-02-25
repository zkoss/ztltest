import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3604TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3604.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3604TestCafe", async (t) => {
	await ztl.initTest(t);
	let wListhead_cafe = await ClientFunction(() =>
		jq(".z-listheader:eq(0)").width(),
	)();
	let wListcell_cafe = await ClientFunction(() =>
		jq(".z-listitem .z-listcell:first-child:eq(0)").width(),
	)();
	let wGroupListcell_cafe = await ClientFunction(() =>
		jq(".z-listitem .z-listcell:first-child:eq(1)").width(),
	)();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-listheader:eq(0)").width())(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem .z-listcell:first-child:eq(0)").width(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem .z-listcell:first-child:eq(1)").width(),
				)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-listgroup.z-listgroup-open")[0],
			)(),
		)
		.notOk();
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-listheader:eq(0)").width())(),
			),
		)
		.eql(ztl.normalizeText(wListhead_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem .z-listcell:first-child:eq(0)").width(),
				)(),
			),
		)
		.eql(ztl.normalizeText(wListcell_cafe));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem .z-listcell:first-child:eq(1)").width(),
				)(),
			),
		)
		.eql(ztl.normalizeText(wGroupListcell_cafe));
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-listgroup.z-listgroup-open")[0],
			)(),
		)
		.notOk();
});
