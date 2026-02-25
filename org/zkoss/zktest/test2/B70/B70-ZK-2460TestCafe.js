import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2460TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2460TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<!--
	B70-ZK-2460.zul
	
	Purpose:
	
	Description:
	
	History:
	Thu, Sep 24, 2014  10:30:22 AM, Created by jameschu
	
	Copyright (C)  Potix Corporation. All Rights Reserved.
-->
<zk>
	<label multiline="true">
		1. Move children quickly and several times, there are no exceptions will be rised.
	</label>
	<window id="demoWindow"
		apply="org.zkoss.zktest.test2.B70_ZK_2460_DemoComposer">
		<style>
			.h-inline-block { display: inline-block; _display: inline; }
		</style>
		<tree id="tree" width="300px" mold="paging" pageSize="4">
			<custom-attributes org.zkoss.zul.tree.maxRodPageSize="1" />
			<treecols>
				<treecol label="My Contact List" />
			</treecols>
		</tree>
	</window>
</zk>`,
	);
	let startL_cafe = await ClientFunction(
		() => jq(".z-hlayout").last().position().left,
	)();
	let startT_cafe = await ClientFunction(
		() => jq(".z-hlayout").last().position().top,
	)();
	let endT_cafe = await ClientFunction(
		() => jq(".z-hlayout").first().position().top,
	)();
	await t.hover(Selector(() => jq(".z-hlayout").last()[0]));
	await ztl.waitResponse(t);
	let cafeCoord_1 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	let cafeCoord_2 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + endT_cafe,
	);

	await t.dragToElement(
		Selector(() => jq(".z-hlayout").last()[0]),
		Selector(() => jq(".z-hlayout").first()[0]),
		{
			offsetX: cafeCoord_1[0],
			offsetY: cafeCoord_1[1],
			destinationOffsetX: cafeCoord_2[0],
			destinationOffsetY: cafeCoord_2[1],
		},
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-messagebox-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 < 1).ok();
	let cafeCoord_3 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	let cafeCoord_4 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + endT_cafe,
	);

	await t.dragToElement(
		Selector(() => jq(".z-hlayout").last()[0]),
		Selector(() => jq(".z-hlayout").first()[0]),
		{
			offsetX: cafeCoord_3[0],
			offsetY: cafeCoord_3[1],
			destinationOffsetX: cafeCoord_4[0],
			destinationOffsetY: cafeCoord_4[1],
		},
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0t = await ClientFunction(
		() => jq(".z-messagebox-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0t < 1).ok();
	let cafeCoord_5 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	let cafeCoord_6 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + endT_cafe,
	);

	await t.dragToElement(
		Selector(() => jq(".z-hlayout").last()[0]),
		Selector(() => jq(".z-hlayout").first()[0]),
		{
			offsetX: cafeCoord_5[0],
			offsetY: cafeCoord_5[1],
			destinationOffsetX: cafeCoord_6[0],
			destinationOffsetY: cafeCoord_6[1],
		},
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tt = await ClientFunction(
		() => jq(".z-messagebox-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0tt < 1).ok();
	let cafeCoord_7 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	let cafeCoord_8 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + endT_cafe,
	);

	await t.dragToElement(
		Selector(() => jq(".z-hlayout").last()[0]),
		Selector(() => jq(".z-hlayout").first()[0]),
		{
			offsetX: cafeCoord_7[0],
			offsetY: cafeCoord_7[1],
			destinationOffsetX: cafeCoord_8[0],
			destinationOffsetY: cafeCoord_8[1],
		},
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttt = await ClientFunction(
		() => jq(".z-messagebox-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0ttt < 1).ok();
	let cafeCoord_9 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	let cafeCoord_10 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + endT_cafe,
	);

	await t.dragToElement(
		Selector(() => jq(".z-hlayout").last()[0]),
		Selector(() => jq(".z-hlayout").first()[0]),
		{
			offsetX: cafeCoord_9[0],
			offsetY: cafeCoord_9[1],
			destinationOffsetX: cafeCoord_10[0],
			destinationOffsetY: cafeCoord_10[1],
		},
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttt = await ClientFunction(
		() => jq(".z-messagebox-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0tttt < 1).ok();
	let cafeCoord_11 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	let cafeCoord_12 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + endT_cafe,
	);

	await t.dragToElement(
		Selector(() => jq(".z-hlayout").last()[0]),
		Selector(() => jq(".z-hlayout").first()[0]),
		{
			offsetX: cafeCoord_11[0],
			offsetY: cafeCoord_11[1],
			destinationOffsetX: cafeCoord_12[0],
			destinationOffsetY: cafeCoord_12[1],
		},
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttt = await ClientFunction(
		() => jq(".z-messagebox-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0ttttt < 1).ok();
	let cafeCoord_13 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	let cafeCoord_14 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + endT_cafe,
	);

	await t.dragToElement(
		Selector(() => jq(".z-hlayout").last()[0]),
		Selector(() => jq(".z-hlayout").first()[0]),
		{
			offsetX: cafeCoord_13[0],
			offsetY: cafeCoord_13[1],
			destinationOffsetX: cafeCoord_14[0],
			destinationOffsetY: cafeCoord_14[1],
		},
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttt = await ClientFunction(
		() => jq(".z-messagebox-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0tttttt < 1).ok();
	let cafeCoord_15 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	let cafeCoord_16 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + endT_cafe,
	);

	await t.dragToElement(
		Selector(() => jq(".z-hlayout").last()[0]),
		Selector(() => jq(".z-hlayout").first()[0]),
		{
			offsetX: cafeCoord_15[0],
			offsetY: cafeCoord_15[1],
			destinationOffsetX: cafeCoord_16[0],
			destinationOffsetY: cafeCoord_16[1],
		},
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttttt = await ClientFunction(
		() => jq(".z-messagebox-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0ttttttt < 1).ok();
	let cafeCoord_17 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	let cafeCoord_18 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + endT_cafe,
	);

	await t.dragToElement(
		Selector(() => jq(".z-hlayout").last()[0]),
		Selector(() => jq(".z-hlayout").first()[0]),
		{
			offsetX: cafeCoord_17[0],
			offsetY: cafeCoord_17[1],
			destinationOffsetX: cafeCoord_18[0],
			destinationOffsetY: cafeCoord_18[1],
		},
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttttt = await ClientFunction(
		() => jq(".z-messagebox-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0tttttttt < 1).ok();
	let cafeCoord_19 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	let cafeCoord_20 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + endT_cafe,
	);

	await t.dragToElement(
		Selector(() => jq(".z-hlayout").last()[0]),
		Selector(() => jq(".z-hlayout").first()[0]),
		{
			offsetX: cafeCoord_19[0],
			offsetY: cafeCoord_19[1],
			destinationOffsetX: cafeCoord_20[0],
			destinationOffsetY: cafeCoord_20[1],
		},
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0ttttttttt = await ClientFunction(
		() => jq(".z-messagebox-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0ttttttttt < 1).ok();
	let cafeCoord_21 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + startT_cafe,
		true,
	);

	let cafeCoord_22 = await ztl.convertCoordStrToArr(
		startL_cafe + "," + endT_cafe,
	);

	await t.dragToElement(
		Selector(() => jq(".z-hlayout").last()[0]),
		Selector(() => jq(".z-hlayout").first()[0]),
		{
			offsetX: cafeCoord_21[0],
			offsetY: cafeCoord_21[1],
			destinationOffsetX: cafeCoord_22[0],
			destinationOffsetY: cafeCoord_22[1],
		},
	);
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0tttttttttt = await ClientFunction(
		() => jq(".z-messagebox-error").length,
	)();
	await t.expect(verifyVariable_cafe_0_0tttttttttt < 1).ok();
});
