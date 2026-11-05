import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B80-ZK-3154TestCafe`
	.page`http://localhost:8080/zktest/test2/B80-ZK-3154.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B80-ZK-3154TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.waitResponse(t);
	const tree = Selector(".z-tree").addCustomDOMProperties({
		pagingShownThoughRowsFit: (el) => {
			const paging = el.querySelector(".z-tree-paging-bottom .z-paging");
			if (!paging || !paging.offsetHeight) return false;
			const rows = el.querySelectorAll(".z-treerow");
			let shownRowsHeight = 0;
			for (let i = 0; i < rows.length; i++) {
				shownRowsHeight += rows[i].getBoundingClientRect().height;
			}
			const allRowsHeight =
				(shownRowsHeight / rows.length) *
				zk.Widget.$(el).paging.getTotalSize();
			const roomWithoutPaging =
				el.querySelector(".z-tree-body").clientHeight +
				paging.offsetHeight;
			return allRowsHeight <= roomWithoutPaging;
		},
	});
	await t
		.expect(tree.pagingShownThoughRowsFit)
		.notOk(
			"the tree should show a paging bar only when its rows do not fit without it",
		);
	if ((await ClientFunction(() => zk.themeName)()) === "iceblue") {
		await t
			.expect(Selector(".z-tree-paging-bottom .z-paging").visible)
			.notOk("under IceBlue the tree should show only one page");
	}
});
