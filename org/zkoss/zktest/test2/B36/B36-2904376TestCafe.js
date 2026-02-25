import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B36-2904376TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B36-2904376TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B36-2904376.zul

	Purpose:
		
	Description:
		
	History:
		Fri Nov 27 16:33:02     2009, Created by jumperchen

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

-->
<zk>
<window id="win1" border="normal" mode="overlapped" left="180px" top="20px" title="parent window" width="850px"  height="650" closable="true" sizable="true">
	<button label="Click Me and then resize the child window, it should be correctly resized.">
		<attribute name="onClick"><![CDATA[
			Window win = new Window();
    		win.setId("win2");
			win.setWidth("200px");
			win.setHeight("200px");
			win.setTitle("child window");
			win.setBorder("normal");
			win.doOverlapped();
			win.setSizable(true);
			win.setLeft("20px");
			win.setTop("20px");
			win1.appendChild(win);
		]]></attribute>
	</button>
	<div height="600px">
	</div>
		<attribute name="onClose"><![CDATA[
			event.stopPropagation();
		]]></attribute>
</window>
</zk>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let w_cafe = await ClientFunction(() => jq("$win2").outerWidth())();
	let h_cafe = await ClientFunction(() => jq("$win2").outerHeight())();
	let dim_cafe = w_cafe / 2 + "," + h_cafe;
	let dim2_cafe = w_cafe / 2 + "," + h_cafe * 2;
	let dim3_cafe = w_cafe + "," + h_cafe / 2;
	let dim4_cafe = w_cafe * 2 + "," + h_cafe / 2;
	let cafeCoord_1 = await ztl.convertCoordStrToArr(dim2_cafe);

	let cafeCoord_2 = await ztl.convertCoordStrToArr(dim_cafe, true);

	await t.drag(
		Selector(() => jq("$win2")[0]),
		cafeCoord_1[0] - cafeCoord_2[0],
		cafeCoord_1[1] - cafeCoord_2[1],
		{ offsetX: cafeCoord_2[0], offsetY: cafeCoord_2[1] },
	);
	await ztl.waitResponse(t);
	let h1_cafe = await ClientFunction(() => jq("$win2").height())();
	await t.expect(h1_cafe != h_cafe).ok();
	await ztl.waitResponse(t);
	let cafeCoord_3 = await ztl.convertCoordStrToArr(dim4_cafe);

	let cafeCoord_4 = await ztl.convertCoordStrToArr(dim3_cafe, true);

	await t.drag(
		Selector(() => jq("$win2")[0]),
		cafeCoord_3[0] - cafeCoord_4[0],
		cafeCoord_3[1] - cafeCoord_4[1],
		{ offsetX: cafeCoord_4[0], offsetY: cafeCoord_4[1] },
	);
	await ztl.waitResponse(t);
	let w1_cafe = await ClientFunction(() => jq("$win2").width())();
	await t.expect(w1_cafe != w_cafe).ok();
});
