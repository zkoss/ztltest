import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F70-ZK-2076TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F70-ZK-2076TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>
<!--
F70-ZK-2076.zul

	Purpose:
		
	Description:
		
	History:
		Wed, June 19, 2014  5:56:04 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<window apply="org.zkoss.zktest.test2.F70_ZK_2076">
	<div>
		1. click each test with clean first. if text1 and text2 are not
		like expected result, that\'s a bug.
	</div>
	<div>
		text1:
		<textbox id="t1" />
	</div>
	<div>
		text2:
		<textbox id="t2" />
	</div>
	<div>
		<button id="b1" label="test1" />
		expceted:
			text1: [test1]
			text2: [] 
	</div>
	<div>
		<button id="b2" label="test2" />
		expceted:
			text1: [test1]
			text2: [test2] 
	</div>
	<div>
		<button id="b3" label="test3" />
		expceted:
			text1: [test1]
			text2: [test3] 
	</div>
	<div>
		<button id="b4" label="test4" />
		expceted:
			text1: [test1]
			text2: [test4] 
	</div>
	<div>
		<button id="b5" label="test5" />
		expceted:
			text1: [test1]
			text2: [] 
	</div>
	<div>
		<button id="b6" label="test6" />
		expceted:
			text1: [test1]
			text2: [test6] 
	</div>
	<div>
		<button id="clean" label="clean" />
	</div>
</window>`,
	);
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$b1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("test1"))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t1").val())()));
	await t
		.expect(ztl.normalizeText(""))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t2").val())()));
	await t.click(Selector(() => jq("$clean")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$b2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("test1"))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t1").val())()));
	await t
		.expect(ztl.normalizeText("test2"))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t2").val())()));
	await t.click(Selector(() => jq("$clean")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$b3")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("test1"))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t1").val())()));
	await t
		.expect(ztl.normalizeText("test3"))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t2").val())()));
	await t.click(Selector(() => jq("$clean")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$b4")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("test1"))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t1").val())()));
	await t
		.expect(ztl.normalizeText("test4"))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t2").val())()));
	await t.click(Selector(() => jq("$clean")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$b5")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("test1"))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t1").val())()));
	await t
		.expect(ztl.normalizeText(""))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t2").val())()));
	await t.click(Selector(() => jq("$clean")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$b6")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("test1"))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t1").val())()));
	await t
		.expect(ztl.normalizeText("test6"))
		.eql(ztl.normalizeText(await ClientFunction(() => jq("$t2").val())()));
});
