import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - B70-ZK-2550TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B70-ZK-2550TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2550.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Jan 27, 2015 12:34:18 PM, Created by hanhsu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
  <window border="normal" title="hello" >
    	<vbox>
          <label value="1. Scroll to the far right in the listbox"/>
          <label value="2. Click the button to fire CONTENTS_CHANGED for first item in model"/>
          <label value="3. The horisontal scroll should not be reset to its leftmost position"/>
    Listbox
  	<listbox id="lb" mold="paging" width="300px" height="120px" >
        <listhead>
        	<listheader label="col2" width="400px"/>            
    	</listhead>
    </listbox>
    Grid
    <grid id="gd" mold="paging" width="300px" height="120px" >
        <columns >
        	<column label="col2" width="400px"/>            
    	</columns >
    </grid>
	<button id="btn" label="Click to fire CONTENTS_CHANGED for first item in model." onClick="changeModel()"/>
  <zscript><![CDATA[
	ListModelList model = new ListModelList();
	model.add("a");
	model.add("b");
	model.add("a");
	model.add("b");
	model.add("a");
	model.add("b");
	model.add("a");
	model.add("b");
	model.add("a");
	model.add("b");
                                                                 
	lb.setModel(model);
	gd.setModel(model);
	public void changeModel() {
		model.set(0, "replaced");
//		model.add("added");
	}
]]></zscript>
  </vbox>
  </window>
</zk>`,
	);
	await ztl.doScroll({
		locator: Selector(() => jq("@listbox")[0]),
		scrollType: "horizontal",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let list_before_cafe = await ztl.getScrollTop({
		locator: Selector(() => zk.Widget.$(jq("@listbox")).$n()),
	});
	await ztl.doScroll({
		locator: Selector(() => jq("@grid")[0]),
		scrollType: "horizontal",
		percent: "100.0",
	});
	await ztl.waitResponse(t);
	await ztl.waitResponse(t);
	let grid_before_cafe = await ztl.getScrollTop({
		locator: Selector(() => zk.Widget.$(jq("@grid")).$n()),
	});
	await t.click(Selector(() => jq("@button")[0]));
	await ztl.waitResponse(t);
	let verifyVariable_cafe_0_0 = await ztl.getScrollTop({
		locator: Selector(() => zk.Widget.$(jq("@listbox")).$n()),
	});
	await t.expect(verifyVariable_cafe_0_0 == list_before_cafe).ok();
	let verifyVariable_cafe_1_1 = await ztl.getScrollTop({
		locator: Selector(() => zk.Widget.$(jq("@grid")).$n()),
	});
	await t.expect(verifyVariable_cafe_1_1 == grid_before_cafe).ok();
});
