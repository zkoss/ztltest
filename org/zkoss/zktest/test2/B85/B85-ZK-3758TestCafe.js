import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3758TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3758.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3758TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq(".z-column").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-column .z-column-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem.z-menuitem-checkable")[1]));
	await ztl.waitResponse(t);
	await t.hover(Selector(() => jq(".z-column").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-column .z-column-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-menuitem.z-menuitem-checkable")[3]));
	await ztl.waitResponse(t);
	const columns = Selector(".z-column");
	await t
		.expect(columns.withText("Title").offsetWidth)
		.eql(0, "the Title column should be hidden");
	await t
		.expect(columns.withText("Hardcover").offsetWidth)
		.eql(0, "the Hardcover column should be hidden");
	const rows = Selector(".z-row").addCustomDOMProperties({
		hiddenContentHeight: (row) =>
			Math.max(
				row.cells[1].firstChild.getBoundingClientRect().height,
				row.cells[3].firstChild.getBoundingClientRect().height,
			),
		shownContentHeight: (row) =>
			Math.max(
				row.cells[0].firstChild.getBoundingClientRect().height,
				row.cells[2].firstChild.getBoundingClientRect().height,
			),
	});
	for (let i = 0; i < 3; i++) {
		const shownHeight = await rows.nth(i).shownContentHeight;
		await t
			.expect(rows.nth(i).hiddenContentHeight)
			.lte(
				shownHeight,
				`the hidden cells should not make row ${i + 1} taller`,
			);
	}
});
