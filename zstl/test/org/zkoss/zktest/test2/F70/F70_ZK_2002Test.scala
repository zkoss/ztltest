package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-2002.zul")
class F70_ZK_2002Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
F70-ZK-2002.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Nov 06, 2013  3:11:22 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<zk>
	<vlayout hflex="1">
		<hlayout hflex="1">
			<label multiline="true">
			1. Normal Model
			-- * you should see the "Tab1" is selected.
			</label>
			<zscript>
				ListModelList model = new ListModelList();
				model.add("Tab1");
				model.add("Tab2");
				model.add("Tab3");
			</zscript>
			<tabbox model="${model}"  hflex="1"/>
		</hlayout>
		<hlayout hflex="1">
			<label multiline="true">
			2. Selection Model
			-- * you should see the "Tab2" is selected.
			</label>
			<zscript>
				ListModelList model2 = new ListModelList();
				model2.add("Tab1");
				model2.add("Tab2");
				model2.add("Tab3");
				
				model2.addToSelection(model2.get(1));
			</zscript>
			<tabbox model="${model2}"  hflex="1"/>
		</hlayout>
		<hlayout hflex="1">
			<label multiline="true">
			3. Model with Template
			-- * you should see the "Tab3" is selected.
			-- * each tab should contain a "user" button
			-- * the background of the content is green color
			</label>
			<zscript>
				ListModelList model3 = new ListModelList();
				model3.add("Tab1");
				model3.add("Tab2");
				model3.add("Tab3");
				
				model3.addToSelection(model3.get(2));
			</zscript>
			<tabbox model="${model3}"  hflex="1">
				<template name="model:tab">
					<tab style="color:red">
					<caption>${each} <button iconSclass="z-icon-user"/></caption>
					</tab>
				</template>
				<template name="model:tabpanel">
					<tabpanel>
						<div style="background:green">
						${each}
						</div>
					</tabpanel>
				</template>
			</tabbox>
		</hlayout>
		<hlayout hflex="1">
			<label multiline="true">
			4. Model with Tabbox renderer
			-- * each tab should start with a "New --" text
			-- * each tabpanel should start with a "New --" text
			-- * click the "add New Tab" button, and then you should see one "New -- tab4" tab is added.
			-- * click the "remove Fisrt Tab" button, and then you should see one "New -- tab1" tab is removed.
			-- * click the "change model" button, and then you should see only two tabs with "New -- Model".
			-- * click the "change selection" button, and then you should see the "New -- Model 2" is selected.
			-- * please select the first tab and click the "check model's selecction, you should see the message is "[Model 1]"
			</label>
			<zscript>
				ListModelList model4 = new ListModelList();
				model4.add("Tab1");
				model4.add("Tab2");
				model4.add("Tab3");
				
				TabboxRenderer renderer = new TabboxRenderer() {
				
					public void renderTab(Tab tab, Object data, int index) throws Exception {
						tab.setLabel("New -- " + data);
					}
					
					public void renderTabpanel(Tabpanel tabpanel, Object data, int index) throws Exception {
						tabpanel.appendChild(new Label("New -- " + data));
					}
				}
			</zscript>
		  <vlayout>
			<tabbox id="t4" model="${model4}"  width="400px" tabboxRenderer="${renderer}"/>
		    <hlayout>
				<button label="add New Tab" onClick='model4.add("Tab4")'/>
				<button label="remove First Tab" onClick='model4.remove("Tab1")'/>
				<button label="change model">
					<attribute name="onClick">
					ListModelList model5 = new ListModelList();
					model5.add("Model 1");
					model5.add("Model 2");
					t4.setModel(model5);
					
					</attribute>
				</button>
				<button label="change model's selection" onClick='model5.addToSelection("Model 2")'/>
				<button label="check model's selection" onClick='alert(model5.getSelection())'/>
		  	</hlayout>
		  </vlayout>
		</hlayout>
	</vlayout>
</zk>
"""  
  runZTL(zscript,
    () => {
      val tb = jq(".z-tabbox").eq(3)
      0 to 2 foreach { index =>
      	click(tb.find(".z-tab:eq(" + index + ")"))
      	waitResponse()
      	
      	verifyTrue("each tabpanel should start with a 'New --' text", tb.find(".z-tabpanel:eq(" + index + "):contains(New --)").exists)
      }
      
      click(jq(".z-button:contains(add New Tab)"))
      waitResponse()
      verifyTrue("should see one 'New -- tab4' tab is added.", tb.find(".z-tab:contains(New -- Tab4)").exists)
      
      click(jq(".z-button:contains(remove First Tab)"))
      waitResponse()
      verifyTrue("should see one 'New -- tab1' tab is removed.", !tb.find(".z-tab:contains(New -- Tab1)").exists)
      
      click(jq(".z-button:contains(change model)"))
      waitResponse()
      verifyTrue("should see only two tabs with 'New -- Model'.", tb.find(".z-tab:contains(New -- Model)").length() == 2)
      
      click(jq(".z-button").eq(6))
      waitResponse()
      verifyTrue("should see the 'New -- Model 2' is selected.", tb.find(".z-tab-selected:contains(New -- Model 2)").exists())
      
      click(tb.find(".z-tab:eq(0)"))
      waitResponse()
      click(jq(".z-button").eq(7))
      waitResponse()
      verifyTrue("should see the message is '[Model 1]'", jq(".z-window").find(".z-label:contains([Model 1])").exists())
      
    })
    
  }
}