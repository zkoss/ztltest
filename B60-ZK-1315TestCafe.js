import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1315TestCafe`
	.page`http://localhost:8080/zktest/test2/B60-ZK-1315.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B60-ZK-1315TestCafe", async (t) => {
	await ztl.initTest(t);
	await t.hover(Selector(() => jq(".z-column:contains(Author)")[0]));
	await ztl.waitResponse(t);
	await t
		.click(
			Selector(() =>
				zk.Widget.$(jq(".z-column:contains(Author)")).$n("btn"),
			),
		)
		.click(
			Selector(() =>
				zk.Widget.$(jq(".z-menuitem:contains(Title)")).$n("a"),
			),
		);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("collapse"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq(".z-column:contains(Title)")).$n(
							"hdfaker",
						),
					).css("visibility"),
				)(),
			),
			"Hide 'Title' column by menupopup.",
		);
	await t.click(Selector(() => jq("$col")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(zk.Widget.$(jq("$col")).$n("sort-icon")).is("[class*=up]"),
			)(),
		)
		.ok("Click 'Publisher' column to sort.");
	await t.hover(Selector(() => jq(".z-column:contains(Author)")[0]));
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-column:contains(Author)")).$n("btn")),
	);
	await ztl.waitResponse(t);
	await t.click(
		Selector(() => zk.Widget.$(jq(".z-menuitem:contains(Title)")).$n("a")),
	);
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("collapse"))
		.notEql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(
						zk.Widget.$(jq(".z-column:contains(Title)")).$n(
							"hdfaker",
						),
					).css("visibility"),
				)(),
			),
			"Show 'Title' column by menupopup.",
		);
});
