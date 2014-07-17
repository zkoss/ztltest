package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys

@Tags(tags = "B70-ZK-2257.zul")
class B70_ZK_2257Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2257.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Apr 17, 2014  9:46:45 AM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
<label multiline="true">
1. click the button "First click can see the bug"
2. The pupop should open at bottom of the button.
</label>
		<window id="dialog" mode="modal" border="normal" width="600px"
			height="400px" >
			<space height="200px" />
			<button sclass="inactiveButton" label="No issue"
				onClick='serviceInvoicePop.open(self,"after_start")'/>
			<button id="target" label="First click can see the bug"
				onClick='serviceWorkspace.open(self,"after_start")'	/>
			<popup id="serviceInvoicePop" style="border: 1px solid #86A4BE;" width="300px">
				<listbox id="invoiceBox" rows="10">
					<listhead>
						<listheader>
							<vlayout>
								<space height="3px" />
								<textbox instant="true"
									width="80%" />
								<label value="labels.service.addmodify.label.inter" />
							</vlayout>
						</listheader>
					</listhead>
					<template name="model" var="each">
						<listitem>
							<listcell label="${each}" value="${each}" />
						</listitem>
					</template>
				</listbox>
			</popup>

			<popup id="serviceWorkspace" style="border: 1px solid #86A4BE;" width="300px">
				<listbox id="workspaceBox" rows="10">
					<listhead>
						<listheader>
							<vlayout>
								<space height="3px" />
								<textbox instant="true"
									width="80%" />
								<label value="Service label" />
							</vlayout>
						</listheader>
					</listhead>
					<template name="model" var="each">
						<listitem>
							<listcell label="${each}" value="${each}" />
						</listitem>
					</template>
				</listbox>
			</popup>
			<zscript><![CDATA[
				ListModelList model60 = new ListModelList();			                  
				for (int i = 0; i<60 ;i ++){
					model60.add("Space "+i);
				}
				workspaceBox.setModel(model60);
				
				ListModelList model3 = new ListModelList();
				model3.add("Invoice a");
				model3.add("Invoice b");
				model3.add("Invoice c");
				invoiceBox.setModel(model3);
			]]></zscript>

		</window>
</zk>
"""  
  runZTL(zscript,
    () => {
      val button = jq("$target");
      val popup = jq("@popup");
      
      click(button);
      waitResponse();
      
      val bBottom = button.offsetTop() + button.height();
      val totalHeight = bBottom + popup.height();
      val windowHeight = Integer.parseInt(getEval("window.innerHeight | Math.max(document.body.clientHeight, document.documentElement.clientHeight)"));
      
      println(bBottom + "," + totalHeight + "," + windowHeight);
      
      val answer = bBottom < popup.offsetTop() || 
    		  totalHeight > windowHeight; // height of window is smaller
      
      verifyTrue("Popup should be shown start from the bottom of button.", answer)
    })
    
  }
}