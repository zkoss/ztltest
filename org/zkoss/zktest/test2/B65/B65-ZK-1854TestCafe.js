import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1854TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1854TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1854.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jul 29, 2013  5:05:31 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
If the "Processing..." is never closed, that\'s a bug.
<window id="win" title="Window" border="normal" width="600px">
<toolbar mold="panel" align="center" vflex="1" hflex="1">
<toolbarbutton label="Left"/>
</toolbar>
</window>
</zk>`,
	);
	await t.expect(await ClientFunction(() => !!jq(".z-loading")[0])()).notOk();
});
