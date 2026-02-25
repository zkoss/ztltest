import { ClientFunction, Selector } from "testcafe";
import * as ztl from "#ztl";
fixture`ZTL TEST - F65-ZK-1351TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("F65-ZK-1351TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
F65-ZK-1351.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Sep 20, 2012  3:07:28 PM, Created by jumperchen

Copyright (C) 2012 Potix Corporation. All Rights Reserved.

-->
<zk>
	<button label="ZK-1351 Feature: Support Messagebox without Buttons">
		<attribute name="onClick"><![CDATA[
			Messagebox.show("You should see no buttons with the dialog!", 
			    "Question", new Messagebox.Button[0],
			    Messagebox.QUESTION,
			        new org.zkoss.zk.ui.event.EventListener(){
			            public void onEvent(Event e){
			                if(Messagebox.ON_OK.equals(e.getName())){
			                    //OK is clicked
			                }else if(Messagebox.ON_CANCEL.equals(e.getName())){
			                    //Cancel is clicked
			                }
			            }
			        }
			    );
		]]></attribute>
	</button>
</zk>`,
	);
	await t.click(Selector(() => jq(".z-button:contains(ZK-1351)")[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			await ClientFunction(
				() => !!jq(".z-messagebox-window .z-button")[0],
			)(),
		)
		.notOk("You should see no buttons with the dialog");
});
