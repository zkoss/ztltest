import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2636TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2636TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2636.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Feb 25, 2015  3:50:42 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<div apply="org.zkoss.bind.BindComposer"
	viewModel="@id(\'vm\') @init(\'org.zkoss.zktest.test2.B70_ZK_2636VM\')"
	validationMessages="@id(\'vmsgs\')"
	form="@id(\'fx\') @load(vm.bean) @save(vm.bean, before=\'save\') @validator(vm.beanValidator, prefix=\'p_\')">
	Please selected an item and click two buttons "Show" and "Save", you should see "null" in the console.
	<combobox id="cbx" model="@load(vm.letters)" selectedItem="@bind(fx.letter)"
		errorMessage="@load(vmsgs[\'p_letter\'])"
		onChange="@command(\'onChangeLetter\')">
		<template name="model">
			<comboitem label="\${each}" />
		</template>
	</combobox>
	<button onClick=\'Clients.log("" + (cbx.getSelectedItem() != null?cbx.getSelectedItem().getLabel() : "null"))\' label="Show"/>
	<button onClick="@command(\'save\')">Save</button>
</div>`,
	);
	await t.click(Selector(() => jq(".z-combobox-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-combobox-popup ul li")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0])).wait(1000);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#zk_log").length > 0 ? jq("#zk_log").val().trim() : "",
				)(),
			),
		)
		.eql(ztl.normalizeText("a\nValidate value: a"));
});
