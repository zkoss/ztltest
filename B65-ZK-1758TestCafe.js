import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1758TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1758TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1758.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Sep 17, 2013 12:20:55 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<window id="win" width="600px" border="normal">
You should see \'#lb listitem 2\' and \'#lb > listitem 2\' below, not \'#lb > listitem 5\' 
	<listbox id="lb">
		<listhead>
			<listheader label="row0" />
		</listhead>
		<listitem>
			<listcell label="item0" />
		</listitem>
		<listitem>
			<listcell label="item1" />
		</listitem>
	</listbox>
	<separator />
	<listbox id="nohead">
		<listitem>
			<listcell label="i0" />
		</listitem>
		<listitem>
			<listcell label="i1" />
		</listitem>
		<listitem>
			<listcell label="i2" />
		</listitem>
	</listbox>
	<separator />
	<hbox>#lb listitem <label id="msg" /></hbox>
	<hbox>#lb > listitem <label id="msg2" /></hbox>
	<zscript><![CDATA[
       	     List comps = org.zkoss.zk.ui.select.Selectors.find(page, "#lb listitem");
      	     msg.setValue("" + comps.size());
      	     comps = org.zkoss.zk.ui.select.Selectors.find(page, "#lb > listitem");
      	     msg2.setValue("" + comps.size());
	]]></zscript>

</window>`,
	);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-hbox .z-label:contains(2)").length,
	)();
	await t
		.expect(verifyVariable_cafe_0_0 == 2)
		.ok(
			"You should see '#lb listitem 2' and '#lb > listitem 2' below, not '#lb > listitem 5'",
		);
});
