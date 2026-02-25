import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B50-3091153TestCafe`
	.page`http://localhost:8080/zktest/test2/B50-3091153.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B50-3091153TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow-selected").length)(),
			),
		)
		.eql(ztl.normalizeText("1"));
	await t.click(Selector(() => zk.Widget.$(jq(".z-treerow")).$n("icon")));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow-selected").length)(),
			),
		)
		.eql(ztl.normalizeText("6"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow").length)(),
			),
		)
		.eql(ztl.normalizeText("6"));
	await t.click(Selector(() => jq('@button[label="deSelectAll"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow-selected").length)(),
			),
		)
		.eql(ztl.normalizeText("0"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow").length)(),
			),
		)
		.eql(ztl.normalizeText("6"));
	await t.click(Selector(() => jq('@button[label="selectAll"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow-selected").length)(),
			),
		)
		.eql(ztl.normalizeText("6"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-treerow").length)(),
			),
		)
		.eql(ztl.normalizeText("6"));
});
