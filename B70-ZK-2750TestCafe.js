import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2750TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2750TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2750.zul

	Purpose:

	Description:

	History:
		Thu Jun  4 17:48:53 CST 2015, Created by chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. click each button in IE
	2. the width of West won\'t change
	</label>
	<borderlayout id="borderLayout">
		<west>
			<vlayout>
				resize the browserwindow, or pressing any of the buttons will move the separator 1px to the right
				<button label="invalidate center" onClick="center.invalidate();"/>
				<button label="invalidate borderlayout" onClick="borderLayout.invalidate();"/>
				<button label="resize borderlayout" onClick="Clients.resize(borderLayout);"/>
			</vlayout>
		</west>
		<center id="center">
		</center>
	</borderlayout>
</zk>`,
	);
	let beginWidth_cafe = await ClientFunction(() => jq("@west").width())();
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("@button").eq(2)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("@west").width())(),
			),
		)
		.eql(ztl.normalizeText(beginWidth_cafe));
});
