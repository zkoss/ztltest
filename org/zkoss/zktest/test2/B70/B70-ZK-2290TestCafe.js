import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2290TestCafe`
	.page`http://localhost:8080/zktest/test2/B70-ZK-2290.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B70-ZK-2290TestCafe", async (t) => {
	await ztl.initTest(t);
	let actionVariable_cafe_0_0 = await ClientFunction(() =>
		jq(".z-listheader").eq(1).width(),
	)();
	let actionVariable_cafe_1_1 = await ClientFunction(() =>
		jq(".z-listheader").eq(6).width(),
	)();
	let actionVariable_cafe_2_2 = await ClientFunction(() =>
		jq(".z-listheader").eq(1).width(),
	)();
	let actionVariable_cafe_3_3 = await ClientFunction(() =>
		jq(".z-listheader").eq(6).width(),
	)();
	let cafeCoord_1 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_0_0 + ",10",
		true,
	);

	let cafeCoord_2 = await ztl.convertCoordStrToArr(
		actionVariable_cafe_3_3 + ",10",
	);

	await t.dragToElement(
		Selector(() => jq(".z-listheader").eq(1)[0]),
		Selector(() => jq(".z-listheader").eq(6)[0]),
		{
			offsetX: cafeCoord_1[0],
			offsetY: cafeCoord_1[1],
			destinationOffsetX: cafeCoord_2[0],
			destinationOffsetY: cafeCoord_2[1],
		},
	);
	await ztl.waitResponse(t);
	await t
		.expect(
			await ztl.hasHScrollbar({
				locator: Selector(() => jq(".z-listbox-body")[0]),
			}),
		)
		.ok("browser should show scrollbar.");
});
