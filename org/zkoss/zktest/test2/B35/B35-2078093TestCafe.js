import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B35-2078093TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2078093TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2078093.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Aug 28 09:14:31 TST 2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->

<zk>
1. Click the first button, then the window will disappear.
<separator/>
2. Click the second button, then the window should be shown, that is correct.
<button id="bt1">
<attribute name="onCreate"><![CDATA[
self.setLabel("DO: Win.setVisible="+(!win.isVisible()));
]]></attribute>

<attribute name="onClick"><![CDATA[
win.setVisible(!win.isVisible());
self.setLabel("DO: Win.setVisible="+(!win.isVisible()));
]]></attribute>
</button>
<button id="bt2" onClick="win.doEmbedded()" label="doEmbedded"/>

<window id="win" title="test"
sizable="true"
minimizable="true" maximizable="true" border="normal">




</window>
</zk>`,
	);
	await t.click(Selector(() => jq("$bt1")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$win").is(":visible"))())
		.notOk();
	await t.click(Selector(() => jq("$bt2")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$win").is(":visible"))())
		.ok();
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-window-embedded").is(":visible"),
			)(),
		)
		.ok();
});
