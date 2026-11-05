import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B85-ZK-3786TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3786.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3786TestCafe", async (t) => {
	await ztl.initTest(t);
	if (await ztl.isBrowserIgnored("ie9,ie10")) {
		console.log("This issue is ignored in current browser! (ie9,ie10)");
		return;
	}
	const selectedRow = Selector(".z-treerow-selected").addCustomDOMProperties({
		distanceToViewBottom: (row) => {
			const body = row.closest(".z-tree-body");
			const viewBottom =
				body.getBoundingClientRect().top +
				body.clientTop +
				body.clientHeight;
			return viewBottom - row.getBoundingClientRect().bottom;
		},
	});
	await t.click(Selector(() => jq('@button[label="add under bottom"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(selectedRow.distanceToViewBottom)
		.within(
			-1,
			1,
			"the tree should scroll just enough to show the selected row at its bottom",
		);
	await t.click(Selector(() => jq('@button[label="add under bottom"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(selectedRow.distanceToViewBottom)
		.within(
			-1,
			1,
			"the tree should scroll just enough to show the selected row at its bottom",
		);
	await t.click(Selector(() => jq('@button[label="add upon top"]')[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq('@button[label="add upon top"]')[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ztl.getScrollTop({
					locator: Selector(() =>
						zk.Desktop._dt.$f("tree", true).$n(),
					),
				}),
			),
		)
		.eql(ztl.normalizeText("0"));
});
