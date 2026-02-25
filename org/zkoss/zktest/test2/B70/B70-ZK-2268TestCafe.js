import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2268TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2268TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2268.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Jul 23, 2015  3:47:34 PM, Created by jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<window height="100%" width="100%" position="center, center">
		<label multiline="true">
			1.press button
			2.press the two buttons (IE 8~10)
			3.you should see the second popup messagebox on the topmost
		</label>
		<button label="Open Modal Window">
			<attribute name="onClick">
				((Window) Executions.createComponents("/test2/B70-ZK-2268-1.zul",self.getParent(),null)).doModal();
			</attribute>
		</button>
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq("button").eq(0)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-toolbarbutton")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-messagebox-button.z-button")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-messagebox-button.z-button")[0]));
	await ztl.waitResponse(t);
});
