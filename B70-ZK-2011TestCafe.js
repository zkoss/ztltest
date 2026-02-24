import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B70-ZK-2011TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2011TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2011.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Nov 12, 2013 10:37:36 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<vbox>
If you cannot see any error message or dialog, this bug is fixed.
<zscript><![CDATA[
ListModelList model = new ListModelList();
model.add("A");
model.add("B");
model.add("C");
]]></zscript>
<tabbox onCreate=\'self.setModel(model);model.addToSelection("B")\'>
	<template name="model:tab">
		<tab label="\${each}"></tab>
	</template>
	<template name="model:tabpanel">
		<tabpanel>Panel \${each}
			<button label="click me \${each}" onClick="//do nothing"></button>
		</tabpanel>
	</template>
</tabbox>
<button label="click me out side" onClick="//do nothing"></button>

<!-- <selectbox onCreate=\'self.setModel(model);model.addToSelection("B")\'/> -->
</vbox>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-window-modal")[0])())
		.notOk("no exception");
});
