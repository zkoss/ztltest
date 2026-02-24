import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-3051-1TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B80-ZK-3051-1TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>
<!--
B80-ZK-3051-1.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Dec 30, 2015  3:14:55 PM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
When a combobox popup is to tall to be opened bellow the combobox, it is opened from the top of the current frame instead.
If the combobox text-input is in the middle of the page, it can be covered by the drop down popup menu, which makes typing difficult.

click the combobox, if the bottom space is not enouth to show popup, the popup will try to show on top of text-input;
if the top space is not enouth either, the popup will force show on the bottom of text-input.
</label>
<iframe width="250px" height="200px" src="test2/B80-ZK-3051-2.zul">
</iframe>
</zk>`,
	);
	await t.wait(1000);
	await ClientFunction(() => {
		jq("iframe").contents().find(".z-combobox-button")[0].click();
	})();
	await ztl.waitResponse(t);
	let h_cafe = await ClientFunction(() =>
		jq("iframe").contents().find(".z-combobox").outerHeight(),
	)();
	let top_cafe = await ClientFunction(
		() => jq("iframe").contents().find(".z-combobox-popup").position().top,
	)();
	await t.expect(ztl.normalizeText(top_cafe)).eql(ztl.normalizeText(h_cafe));
});
