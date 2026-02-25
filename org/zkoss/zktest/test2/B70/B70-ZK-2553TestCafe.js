import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2553TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2553TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2553.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jan 26, 2015  2:27:19 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. load this page without js error
	</label>
	<grid>
		<frozen columns="1"/>
		<columns>
			
		</columns>
		<rows>
		</rows>
	</grid>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => jq(".z-error").is(":visible"))())
		.notOk();
});
