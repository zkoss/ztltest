import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B65-ZK-1920TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1920TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1920.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Sep 05, 2013 12:54:49 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
1.Select the "handler"
2.Some listitems added to the Listbox, itemTypesLbx, and 5 items were selected.
3.Select the "handler" again to run the same code.
4.The top 5 items of the listbox should be selected.
</label>
<listbox id="handlerLbx" multiple="true" checkmark="true">
	<attribute name="onSelect"><![CDATA[
        		itemTypesLbx.getItems().clear();
        		for (int i = 0; i < 10; i++) {
        			Listitem item = new Listitem("newItem"+i);
        			if (i < 5 )
        				item.setSelected(true);
        			itemTypesLbx.appendChild(item);
        		}
	]]></attribute>
	<listitem label="handler" />
</listbox>
<listbox id="itemTypesLbx" multiple="true" checkmark="true"/>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-listitem:contains(handler)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => jq(".z-listbox:eq(1) .z-listitem-selected").length,
	)();
	await t.expect(verifyVariable_cafe_0_0 == 5).ok("5 items were selected");
	await t.click(Selector(() => jq(".z-listitem:contains(handler)")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => jq(".z-listbox:eq(1) .z-listitem-selected").length,
	)();
	await t.expect(verifyVariable_cafe_1_1 == 5).ok("5 items were selected");
});
