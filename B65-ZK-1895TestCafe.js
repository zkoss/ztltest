import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1895TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1895TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1895.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Aug 27, 2013 11:22:27 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<window border="none" width="100%" height="100%" id="test">
If you cannot see any content of the listbox, that\'s a bug.
    <zscript><![CDATA[
    void setModel(){
    	ListModelList model = new ListModelList();
    	for(int i=0;i<100;i++){
    		model.add("A"+i);
		}
    	listbox.setModel(model);
    }
    ]]></zscript>
    <listbox id="listbox" vflex="true" mold="paging"
    	autopaging="true" onCreate="setModel()">
    	<custom-attributes org.zkoss.zul.listbox.rod="true"/>
    	<listhead>
    		<listheader sort="auto">Title</listheader>
    	</listhead>
    	<template name="model">
    		<listitem>
    			<listcell label="\${each}" />
    		</listitem>
    	</template>
    </listbox>
</window>`,
	);
	await t
		.expect(await ClientFunction(() => !!jq(".z-listitem")[0])())
		.ok("you should see the content of the listbox");
});
