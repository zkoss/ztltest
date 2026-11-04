import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B30-1825896TestCafe`
	.page`http://localhost:8080/zktest/test2/B30-1825896.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B30-1825896TestCafe", async (t) => {
	await ztl.initTest(t);
	let colWidth_cafe = await ClientFunction(() =>
		jq(".z-column:eq(3)").width(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(colWidth_cafe / 2 + ",5");

	let cafeCoord_2 = await ztl.convertCoordStrToArr(
		colWidth_cafe - 2 + ",5",
		true,
	);

	await t.drag(
		Selector(() => jq(".z-column:eq(3)")[0]),
		cafeCoord_1[0] - cafeCoord_2[0],
		cafeCoord_1[1] - cafeCoord_2[1],
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	const columnRight = (await Selector(".z-column").nth(3).boundingClientRect)
		.right;
	const datebox = Selector(
		() => jq(".z-row-inner:eq(3)").find(".z-datebox")[0],
	).addCustomDOMProperties({
		visibleRight: (box) => {
			let right = box.getBoundingClientRect().right;
			for (let el = box.parentElement; el; el = el.parentElement) {
				if (getComputedStyle(el).overflowX !== "visible") {
					right = Math.min(right, el.getBoundingClientRect().right);
				}
			}
			return right;
		},
	});
	await t
		.expect(datebox.visibleRight)
		.lte(columnRight + 1, "the datebox should not show past its column");
});
