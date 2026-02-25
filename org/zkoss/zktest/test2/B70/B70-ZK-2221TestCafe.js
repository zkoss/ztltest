import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2221TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2221TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2221.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Mar 21, 2014 11:59:59 AM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
If you don\'t see the loading process icon running infinite loop, that\'s correct. (that means no JS error)
	<zscript><![CDATA[
		import org.zkoss.zktest.test2.big.*;
		import org.zkoss.util.*;
		
		FakerMatrixModel BigData = new FakerMatrixModel(0, 0);
	]]></zscript>
	<biglistbox id="biglist"  hflex="1" vflex="1" colWidth="130px" model="\${BigData}"/>
</zk>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-error")[0])())
		.notOk("should see no javascript error");
});
