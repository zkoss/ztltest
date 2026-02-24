import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2832TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2832TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2832.zul

	Purpose:
		
	Description:
		
	History:
		Fri Jul 31 12:04:29 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
    <label multiline="true">
        1. Please open "Test Selection issue"
        2. Please select "Child 1", it should be selected.
        2. Please select "Child 2", if it cannot be selected that\'s a bug.
    </label>
<navbar id="navbar" orient="vertical" collapsed="false"
        onSelect="self.getSelectedItem().invalidate()">

    <nav label="Test Selection issue" iconSclass="z-icon-home">
        <navitem label="Child 1"/>
        <navitem label="Child 2"/>
        <navitem label="Child 3"/>
        <navitem label="Child 4"/>
        <navitem label="Child 5"/>
    </nav>
</navbar>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-nav-content")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-navitem-content").eq(0)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-navitem").eq(0).hasClass("z-navitem-selected"),
			)(),
		)
		.ok();
	await t.click(Selector(() => jq(".z-navitem-content").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(() =>
				jq(".z-navitem").eq(1).hasClass("z-navitem-selected"),
			)(),
		)
		.ok();
});
