import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2568TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2568TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2568.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Feb 04, 2015  8:32:32 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<grid width="100%">
	    <rows>
	        <group>
		        <label value="Group1: (gp1)"/>
            </group>
	        <row>
	            <cell><label value="abc" /></cell>
	        </row>
	    </rows>
	</grid>
	<listbox width="100%">
        <listgroup label="Listgroup" />
        <listitem>
            <listcell><label value="abc" /></listcell>
        </listitem>
	</listbox>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-group-inner").first().attr("colSpan"),
				)(),
			),
		)
		.notEql(ztl.normalizeText("2"), "");
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listgroup-inner").first().attr("colSpan"),
				)(),
			),
		)
		.notEql(ztl.normalizeText("2"), "");
});
