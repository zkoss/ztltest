import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B65-ZK-1867TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B65-ZK-1867TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1867.zul

	Purpose:
		
	Description:
		
	History:
		Fri, Jul 26, 2013  4:08:40 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1.select on listbox, you will see the grid shows only one row as same as your selection
	2.click add to add more new items.
	3.select on the new item of the listbox, the new added item should be shown on grid
	</label>
	<window border="normal" hflex="1" vflex="1">
	<zscript><![CDATA[
              
		ListModelList model1 = new ListModelList();
		model1.add("A");
		model1.add("B");
		model1.add("C");
		ListModelList model2 = new ListModelList();
		model2.add("A");
		model2.add("B");
		model2.add("C");
		
		void doSelect(int index){
			List children = grid1.getRows().getChildren();
			for(int i=0;i<children.size();i++){
				children.get(i).setVisible(i==index?true:false);
			}
		}
		void doAdd(){
			String str = ""+new Date(); 
			model1.add(str);
			model2.add(str);
		}
	]]></zscript>
		<button label="add" onClick="doAdd()"/>
		<listbox id="listbox1" model="\${model1}" onSelect="doSelect(listbox1.getSelectedIndex())"></listbox>
		<grid id="grid1" model="\${model2}">
			<template name="model">
				<row visible="false">
					<label value="\${each}"></label>
				</row>
			</template>
		</grid>
		
	</window>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-listitem:contains(A)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(ztl.normalizeText("1"))
		.eql(
			ztl.normalizeText(
				await ClientFunction(() => jq(".z-row:visible").length)(),
			),
			"the grid shows only one row as same as your selection",
		);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:visible").text().replace(/\s/g, " "),
				)(),
			),
		)
		.contains(ztl.normalizeText("A"), "");
	await t.click(Selector(() => jq(".z-button:contains(add)")[0]));
	await ztl.waitResponse(t);
	await t.click(Selector(() => jq(".z-listitem:last-child")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-row:visible").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq(".z-listitem:last-child").text().replace(/\s/g, " "),
				)(),
			),
			"the new added item should be shown on grid",
		);
});
