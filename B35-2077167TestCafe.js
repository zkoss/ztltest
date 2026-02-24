import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B35-2077167TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B35-2077167TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B35-2077167.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Aug 27 16:10:00 TST 2008, Created by jumperchen
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<zk>
1.Please click the "Minimize" icon of the window, and then click the "visible" button.
<separator/>
2. The window appears, that is correct.
<button id="btn" onClick="minmaxWin.setVisible(true);" label="visible"/>
<window id="minmaxWin" width="300px" title="test caption window"
minimizable="true" border="normal">
</window>
</zk>`,
	);
	await t.click(Selector(() => zk.Widget.$(jq("$minmaxWin")).$n("min")));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$minmaxWin").is(":visible"))())
		.notOk();
	await t.click(Selector(() => jq("$btn")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => jq("$minmaxWin").is(":visible"))())
		.ok();
});
