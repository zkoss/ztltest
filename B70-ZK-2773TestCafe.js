import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2773TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2773TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2773.zul

	Purpose:

	Description:

	History:
		Tue Jun  9 10:40:46 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<window border="normal" title="hello">
	Please click the datebox\'s icon to show the popup, and it shouldn\'t cover the datebox itself.
	<vlayout>
		<div height="800px">Welcome to ZK</div>
		<datebox format="dd/MM/yyyy" />
		<div height="1200px">Welcome to ZK</div>
	</vlayout>
</window>`,
	);
	await t.click(Selector(() => jq(".z-datebox-button")[0]));
	await ztl.waitResponse(t);
	let tl_cafe_0 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().left,
	)();
	let tl_cafe_1 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().top,
	)();
	let tl_cafe_2 = await ClientFunction(() => jq("@datebox").offset().left)();
	let tl_cafe_3 = await ClientFunction(() => jq("@datebox").offset().top)();
	let tl_cafe_4 = await ClientFunction(() =>
		jq(".z-datebox-popup").height(),
	)();
	let tl_cafe_5 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().left,
	)();
	let tl_cafe_6 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().top,
	)();
	let tl_cafe_7 = await ClientFunction(() =>
		jq(".z-datebox-popup").width(),
	)();
	let tl_cafe_8 = await ClientFunction(() => jq("@datebox").offset().left)();
	let tl_cafe_9 = await ClientFunction(() => jq("@datebox").offset().top)();
	let tl_cafe =
		tl_cafe_2 > tl_cafe_0 &&
		tl_cafe_2 < tl_cafe_0 + tl_cafe_7 &&
		tl_cafe_3 > tl_cafe_1 &&
		tl_cafe_3 < tl_cafe_1 + tl_cafe_4;
	let tr_cafe_10 = await ClientFunction(() => jq("@datebox").offset().top)();
	let tr_cafe_11 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().left,
	)();
	let tr_cafe_12 = await ClientFunction(() => jq("@datebox").offset().left)();
	let tr_cafe_13 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().left,
	)();
	let tr_cafe_14 = await ClientFunction(() => jq("@datebox").offset().top)();
	let tr_cafe_15 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().top,
	)();
	let tr_cafe_16 = await ClientFunction(() =>
		jq(".z-datebox-popup").width(),
	)();
	let tr_cafe_17 = await ClientFunction(() =>
		jq(".z-datebox-popup").height(),
	)();
	let tr_cafe_18 = await ClientFunction(() => jq("@datebox").width())();
	let tr_cafe_19 = await ClientFunction(() => jq("@datebox").offset().left)();
	let tr_cafe_20 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().top,
	)();
	let tr_cafe_21 = await ClientFunction(() => jq("@datebox").width())();
	let tr_cafe =
		tr_cafe_12 + tr_cafe_18 > tr_cafe_11 &&
		tr_cafe_12 + tr_cafe_18 < tr_cafe_11 + tr_cafe_16 &&
		tr_cafe_10 > tr_cafe_15 &&
		tr_cafe_10 < tr_cafe_15 + tr_cafe_17;
	let bl_cafe_22 = await ClientFunction(() => jq("@datebox").offset().left)();
	let bl_cafe_23 = await ClientFunction(() => jq("@datebox").height())();
	let bl_cafe_24 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().left,
	)();
	let bl_cafe_25 = await ClientFunction(() => jq("@datebox").offset().top)();
	let bl_cafe_26 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().top,
	)();
	let bl_cafe_27 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().left,
	)();
	let bl_cafe_28 = await ClientFunction(() => jq("@datebox").offset().left)();
	let bl_cafe_29 = await ClientFunction(() =>
		jq(".z-datebox-popup").width(),
	)();
	let bl_cafe_30 = await ClientFunction(() => jq("@datebox").height())();
	let bl_cafe_31 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().top,
	)();
	let bl_cafe_32 = await ClientFunction(() => jq("@datebox").offset().top)();
	let bl_cafe_33 = await ClientFunction(() =>
		jq(".z-datebox-popup").height(),
	)();
	let bl_cafe =
		bl_cafe_22 > bl_cafe_24 &&
		bl_cafe_22 < bl_cafe_24 + bl_cafe_29 &&
		bl_cafe_25 + bl_cafe_23 > bl_cafe_26 &&
		bl_cafe_25 + bl_cafe_23 < bl_cafe_26 + bl_cafe_33;
	let br_cafe_34 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().top,
	)();
	let br_cafe_35 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().top,
	)();
	let br_cafe_36 = await ClientFunction(() => jq("@datebox").offset().left)();
	let br_cafe_37 = await ClientFunction(() => jq("@datebox").height())();
	let br_cafe_38 = await ClientFunction(() => jq("@datebox").width())();
	let br_cafe_39 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().left,
	)();
	let br_cafe_40 = await ClientFunction(() =>
		jq(".z-datebox-popup").height(),
	)();
	let br_cafe_41 = await ClientFunction(() => jq("@datebox").width())();
	let br_cafe_42 = await ClientFunction(() => jq("@datebox").offset().left)();
	let br_cafe_43 = await ClientFunction(() =>
		jq(".z-datebox-popup").width(),
	)();
	let br_cafe_44 = await ClientFunction(() => jq("@datebox").height())();
	let br_cafe_45 = await ClientFunction(() => jq("@datebox").offset().top)();
	let br_cafe_46 = await ClientFunction(() => jq("@datebox").offset().top)();
	let br_cafe_47 = await ClientFunction(
		() => jq(".z-datebox-popup").offset().left,
	)();
	let br_cafe =
		br_cafe_36 + br_cafe_38 > br_cafe_39 &&
		br_cafe_36 + br_cafe_38 < br_cafe_39 + br_cafe_43 &&
		br_cafe_45 + br_cafe_37 > br_cafe_34 &&
		br_cafe_45 + br_cafe_37 < br_cafe_34 + br_cafe_40;
	await t.expect(tl_cafe || tr_cafe || bl_cafe || br_cafe).notOk();
});
