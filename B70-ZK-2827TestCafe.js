import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2827TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2827TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2827.zul

	Purpose:
		
	Description:
		
	History:
		Mon Aug  3 09:52:49 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<div apply="org.zkoss.zktest.test2.B70_ZK_2827">
		<button id="addContainer" label="Click Me"/>
	</div>
</zk>`,
	);
	await t.click(Selector(() => jq("$addContainer")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq("button").eq(1)[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() =>
					!!jq(".z-messagebox-error")[0] ||
					!!jq(".z-errorbox")[0] ||
					jq(".z-error")[0],
			)(),
		)
		.notOk();
});
