import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2095278TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2095278TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2095278.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Sep  8 10:18:18     2008, Created by tomyeh
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<window width="100%" height="100%">
<vbox>
You shall see the "hello" button shown up when you click the "toggle visibility"
button.
<button id="tv" label="toggle visibility" onClick="bt.visible=!bt.visible"/>
<button id="bt" label="hello" visible="false"/>
</vbox>
</window>`,
	);
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$bt").is(":visible"))())
		.notOk();
	await t.click(Selector(() => jq("$tv")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => jq("$bt").is(":visible"))()).ok();
});
