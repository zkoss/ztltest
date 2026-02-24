import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2194TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2194TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2194.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Mar 24, 2014  4:21:13 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
Please click this button, and the item 8 should be scroll into the viewport.
    <button label="Scroll into view">
    <attribute name="onClick"><![CDATA[
    Clients.scrollIntoView(item);
    ]]></attribute>
    </button>
    <div height="100%"/>
    <listbox rows="3">
        <listitem label="1"/>
        <listitem label="2"/>
        <listitem label="3"/>
        <listitem label="4"/>
        <listitem label="5"/>
        <listitem label="6"/>
        <listitem label="7"/>
        <listitem id="item" label="8"/>
        <listitem label="9"/>
        <listitem label="10"/>          
    </listbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() => !!jq(".z-listitem:contains(8)")[0])(),
		)
		.ok("the item 8 should be scroll into the viewport.");
});
