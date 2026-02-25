import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2775TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2775TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2775.zul

	Purpose:

	Description:

	History:
		Mon Jun  8 14:32:19 CST 2015, Created by chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk xmlns:w="client">
 <label multiline="true">
 1. open this page
 2. you should see popup is open without loading mask
 </label>
 <div id="d1" height="100%"  popup="pop" onCreate=\'pop.open(self, "middle_center")\'>
  <popup id="pop" onOpen=\'Clients.showNotification("onOpen")\'>
   <div width="200px" height="200px">
    Popup Content
   </div>
  </popup>
 </div>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-apply-mask")[0])())
		.notOk();
});
