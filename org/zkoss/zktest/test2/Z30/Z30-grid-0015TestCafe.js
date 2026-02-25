import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - Z30-grid-0015TestCafe`
	.page`http://localhost:8080/zktest/test2/Z30-grid-0015.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("Z30-grid-0015TestCafe", async (t) => {
	await ztl.initTest(t);
	await t
		.expect(ztl.normalizeText("Item 1.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid1").find(".z-row").eq(0).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid1").find(".z-row").eq(1).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid1").find(".z-row").eq(2).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid1").find(".z-row").eq(3).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item A.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid2").find(".z-row").eq(0).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item B.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid2").find(".z-row").eq(1).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item C.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid2").find(".z-row").eq(2).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item D.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid2").find(".z-row").eq(3).find(".z-label").html(),
				)(),
			),
		);
	await t.click(Selector(() => jq(".z-paging-next")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Item 5.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid1").find(".z-row").eq(0).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 6.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid1").find(".z-row").eq(1).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 7.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid1").find(".z-row").eq(2).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item E.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid2").find(".z-row").eq(0).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item F.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid2").find(".z-row").eq(1).find(".z-label").html(),
				)(),
			),
		);
	await t.click(Selector(() => jq(".z-paging-previous")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("Item 1.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid1").find(".z-row").eq(0).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 2.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid1").find(".z-row").eq(1).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 3.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid1").find(".z-row").eq(2).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item 4.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid1").find(".z-row").eq(3).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item A.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid2").find(".z-row").eq(0).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item B.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid2").find(".z-row").eq(1).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item C.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid2").find(".z-row").eq(2).find(".z-label").html(),
				)(),
			),
		);
	await t
		.expect(ztl.normalizeText("Item D.1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("$grid2").find(".z-row").eq(3).find(".z-label").html(),
				)(),
			),
		);
});
