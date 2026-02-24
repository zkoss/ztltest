import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B85-ZK-3660TestCafe`
	.page`http://localhost:8080/zktest/test2/B85-ZK-3660.zul`.beforeEach(
	async () => {
		await ClientFunction(() => {
			window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
				function (value, options) {
					return value;
				};
		})();
	},
);
test("B85-ZK-3660TestCafe", async (t) => {
	await ztl.initTest(t);
	let clickPosition_cafe_0 = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let clickPosition_cafe_1 = await ClientFunction(
		() => jq(".z-column").eq(0).offset().left,
	)();
	let clickPosition_cafe =
		clickPosition_cafe_1 + clickPosition_cafe_0 - 10 + ",0";
	let cafeCoord_1 = await ztl.convertCoordStrToArr(clickPosition_cafe);

	await t.doubleClick(
		Selector(() => jq(".z-column").eq(0)[0]),
		{ offsetX: cafeCoord_1[0], offsetY: cafeCoord_1[1] },
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-row-inner").eq(0)[0]));
	await ztl.waitResponse(t);
	let newClickPosition_cafe_2 = await ClientFunction(
		() => jq(".z-column").eq(0).offset().left,
	)();
	let newClickPosition_cafe_3 = await ClientFunction(() =>
		jq(".z-column").eq(0).width(),
	)();
	let newClickPosition_cafe =
		newClickPosition_cafe_2 + newClickPosition_cafe_3 - 10 + ",0";
	let cafeCoord_2 = await ztl.convertCoordStrToArr(newClickPosition_cafe);

	await t.doubleClick(
		Selector(() => jq(".z-column").eq(0)[0]),
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	await ztl.waitResponse(t);
	let clickPosition_cafe_0t = await ClientFunction(() =>
		jq(".z-listheader").eq(0).width(),
	)();
	let clickPosition_cafe_1t = await ClientFunction(
		() => jq(".z-listheader").eq(0).offset().left,
	)();
	let clickPosition_cafet =
		clickPosition_cafe_1t + clickPosition_cafe_0t - 10 + ",0";
	let cafeCoord_3 = await ztl.convertCoordStrToArr(clickPosition_cafet);

	await t.doubleClick(
		Selector(() => jq(".z-listheader").eq(0)[0]),
		{ offsetX: cafeCoord_3[0], offsetY: cafeCoord_3[1] },
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listcell").eq(0)[0]));
	await ztl.waitResponse(t);
	let newClickPosition_cafe_2t = await ClientFunction(
		() => jq(".z-listheader").eq(0).offset().left,
	)();
	let newClickPosition_cafe_3t = await ClientFunction(() =>
		jq(".z-listheader").eq(0).width(),
	)();
	let newClickPosition_cafet =
		newClickPosition_cafe_2t + newClickPosition_cafe_3t - 10 + ",0";
	let cafeCoord_4 = await ztl.convertCoordStrToArr(newClickPosition_cafet);

	await t.doubleClick(
		Selector(() => jq(".z-listheader").eq(0)[0]),
		{ offsetX: cafeCoord_4[0], offsetY: cafeCoord_4[1] },
	);
	await ztl.waitResponse(t);
	let clickPosition_cafe_0tt = await ClientFunction(() =>
		jq(".z-treecol").eq(0).width(),
	)();
	let clickPosition_cafe_1tt = await ClientFunction(
		() => jq(".z-treecol").eq(0).offset().left,
	)();
	let clickPosition_cafett =
		clickPosition_cafe_1tt + clickPosition_cafe_0tt - 10 + ",0";
	let cafeCoord_5 = await ztl.convertCoordStrToArr(clickPosition_cafett);

	await t.doubleClick(
		Selector(() => jq(".z-treecol").eq(0)[0]),
		{ offsetX: cafeCoord_5[0], offsetY: cafeCoord_5[1] },
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-treecell").eq(0)[0]));
	await ztl.waitResponse(t);
	let newClickPosition_cafe_2tt = await ClientFunction(
		() => jq(".z-treecol").eq(0).offset().left,
	)();
	let newClickPosition_cafe_3tt = await ClientFunction(() =>
		jq(".z-treecol").eq(0).width(),
	)();
	let newClickPosition_cafett =
		newClickPosition_cafe_2tt + newClickPosition_cafe_3tt - 10 + ",0";
	let cafeCoord_6 = await ztl.convertCoordStrToArr(newClickPosition_cafett);

	await t.doubleClick(
		Selector(() => jq(".z-treecol").eq(0)[0]),
		{ offsetX: cafeCoord_6[0], offsetY: cafeCoord_6[1] },
	);
	await ztl.waitResponse(t);
});
