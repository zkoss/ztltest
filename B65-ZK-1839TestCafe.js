import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1839TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1839TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1839.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jul 15, 2013  2:26:53 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	Please click the dropdown list(select tag), it should show up the list on IE9. Otherwise, it is a bug.
	<listbox>
		<listhead sizable="true">
			<listheader align="center" width="40px" />
			<listheader align="center" width="40px" />
			<listheader align="center" width="40px" />
			<listheader label="Subject" sort="auto" />
			<listheader label="Received" width="200px" />
		</listhead>
		<listitem height="28px" draggable="aaa">
			<listcell />
			<listcell />
			<listcell />
			<listcell />
			<listcell>
				<listbox width="100%" mold="select">
					<listitem label="Test1" selected="true" />
					<listitem label="Test2" />
				</listbox>
			</listcell>
		</listitem>
	</listbox>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-select")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ClientFunction(
		() => !!jq(".z-option:contains(Test1)")[0],
	)();
	let verifyVariable_cafe_1_1 = await ClientFunction(
		() => !!jq(".z-option:contains(Test1)")[0],
	)();
	await t
		.expect(verifyVariable_cafe_0_0 && verifyVariable_cafe_0_0)
		.ok("it should show up the list");
});
