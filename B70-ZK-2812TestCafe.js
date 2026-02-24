import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2812TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2812TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2812.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jul 13, 2015  12:10:34 PM, Created by jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<window apply="org.zkoss.bind.BindComposer" viewModel="@id(\'vm\') @init(\'org.zkoss.zktest.test2.B70_ZK_2812_VM\')">
		<label multiline="true">
			1. open/close each group in grid
			2. you should see notifications
		</label>
		<grid model="@load(vm.groupmodel)">
			<columns>
				<column label="Cols" />
			</columns>
			<template name="model:group">
				<group label="\${each}" onOpen="@command(\'open\')"/>
			</template>
			<template name="model">
				<row>
					<label value="\${each}" />
				</row>
			</template>
		</grid>
	</window>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-notification")[0])())
		.notOk();
	await t.click(Selector(() => jq(".z-group-icon").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-notification")[0])())
		.ok();
	await t.click(Selector(() => jq(".z-group-icon").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-notification")[0])())
		.ok();
	await t.click(Selector(() => jq(".z-group-icon").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-notification")[0])())
		.ok();
	await t.click(Selector(() => jq(".z-group-icon").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-notification")[0])())
		.ok();
});
