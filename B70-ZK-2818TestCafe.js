import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2818TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2818TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<!--
B70-ZK-2818.zul

	Purpose:

	Description:

	History:
		Thu Jul 23 11:00:37 CST 2015, Created by jameschu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<window apply="org.zkoss.zktest.test2.B70_ZK_2818">
	<label>Refresh several times, you should not see "I am busy" holding still</label>
    <timer id="timer" delay="1000" repeats="true" />
    <label>outer component</label>
</window>`,
	);
	await t.wait(1000);
	await t
		.expect(await ClientFunction(() => !!jq(".z-apply-loading")[0])())
		.notOk();
});
