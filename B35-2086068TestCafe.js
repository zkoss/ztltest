import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2086068TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2086068TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2086068.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Mon Sep  1 13:04:38 TST 2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<window>
1. Click "Change minimized" button twice.
<separator/>
2. Click "Add top toolbar" button.
<separator/>
3. Panel shouldn\'t disappear.(That is correct)
<panel id="p1" title="Panel Component" border="normal" width="500px"
maximizable="true" minimizable="true">
<panelchildren>
<grid>
<columns>
<column label="Name" />
<column label="Description" />
</columns>
<rows>
<row>
<label value="Ivan" />
<label value="MIS" />
</row>
<row>
<label value="ohpizz" />
<label value="Testing" />
</row>
</rows>
</grid>
</panelchildren>
</panel>
<button id="change" label="Change minimized">
<attribute name="onClick">
p1.minimized=!p1.minimized;
</attribute>
</button>

<separator />

<button id="add" label="Add top toolbar">
<attribute name="onClick">
if(topbar.visible==false) {
p1.addToolbar("tbar", topbar);
topbar.visible=true;
} else
alert("Only one top toolbar is allowed");
</attribute>
</button>
<toolbar id="topbar" visible="false">
<toolbarbutton label="top1" />
<toolbarbutton label="top2" />
</toolbar>
<toolbar id="bottombar" visible="false">
<toolbarbutton label="bottom1" />
<toolbarbutton label="bottom2" />
</toolbar>
<toolbar id="footbar" visible="false">
<toolbarbutton label="foot1" />
<toolbarbutton label="foot2" />
</toolbar>
</window>`,
	);
	await t.click(Selector(() => jq("$change")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$p1").is(":visible"))())
		.notOk();
	await t.click(Selector(() => jq("$change")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => jq("$p1").is(":visible"))()).ok();
	await t.click(Selector(() => jq("$add")[0]));
	await ztl.waitResponse(t);
	await t.expect(await ClientFunction(() => jq("$p1").is(":visible"))()).ok();
});
