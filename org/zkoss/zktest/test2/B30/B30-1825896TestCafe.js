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
	let verifyVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-row-inner:eq(3)").find(".z-datebox").innerWidth(),
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-column:eq(3)").outerWidth(),
	)();
	await t.expect(verifyVariable_cafe_0_0 < verifyVariable_cafe_1_1).ok();
});
