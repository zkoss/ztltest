import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2280TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2280TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2280.zul

	Purpose:
		
	Description:
		
	History:
		Wed, May 07, 2014  5:06:20 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<paging id="pag" width="500px" pageSize="10" totalSize="12" sclass="floatright" pageIncrement="1" detailed="true" onPaging=""/>
	Please click the following buttons, and the detail text of the paging bar at the right side will be updated.
	<button id="plus" onClick="pag.setTotalSize(pag.getTotalSize() + 1);" label="+"/>
	<button id="minus" onClick="pag.setTotalSize(pag.getTotalSize() - 1);" label="-"/>
</zk>`,
	);
	await t.click(Selector(() => jq("$plus")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$minus")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("$minus")[0]));
	await ztl.waitResponse(t);
	await t
		.expect("false")
		.ok("the detail text of the paging bar should be updated");
});
