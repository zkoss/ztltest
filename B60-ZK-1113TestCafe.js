import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B60-ZK-1113TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B60-ZK-1113TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<!--
B60-ZK-1113.zul

	Purpose:
		
	Description:
		
	History:
		Mon, May 6, 2012 09:56:17 AM, Created by vincent

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
-->
<zk>
	<window id="win" apply="org.zkoss.zktest.test2.B60_ZK_1113_Composer">
		<div>
		1. ZK EE only
		2. open chosenbox and press \'ESC\' key
		3. you should see nothing
		</div>
		<chosenbox id="cbx" width="500px" model="\${win$composer.getModel()}" emptyMessage="------------------"/>
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-chosenbox")[0]));
	await ztl.waitResponse(t);
	await t.pressKey("esc");
	await ztl.waitResponse(t);
	await t
		.expect(await ClientFunction(() => !!jq(".z-chosenbox")[0])())
		.notOk("you should see nothing");
});
