package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2013.zul")
class B70_ZK_2013Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2013.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Nov 12, 2013  4:51:55 PM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<vbox>
<label multiline="true">
1. Click "Add" button, you should see the "Y" tab is added at the end of the tabs.
2. The create time of the "B" tab shoud not be changed.
3. Select the "Y" tab and see its "create time" is the latest one which is different from "B" tab.
4. Click "Remove" button, the "C" tab will be remove and the "create time" of the "Y" tab is the same as before.
</label>
<zscript><![CDATA[
ListModelList model = new ListModelList();
model.add("A");
model.add("B");
model.add("C");
]]></zscript>
<tabbox onCreate='self.setModel(model);model.addToSelection("B")'>
	<template name="model:tab">
		<tab label="${each} ${count}"></tab>
	</template>
	<template name="model:tabpanel">
		<tabpanel>Panel ${each} ${count}
			<button label="click me ${each}" onClick="//do nothing"></button>
			<include src="test2/B70-ZK-2013_1.zul"/>
		</tabpanel>
	</template>
</tabbox>
<button label="click me out side" onClick="//do nothing"></button>
<button label="Add" onClick='model.add("Y")'></button>
<button label="Remove" onClick='model.remove("C")'></button>
</vbox>
"""  
  runZTL(zscript,
    () => {
      click(jq(".z-tab:contains(B)"))
      waitResponse()
      val time = jq(".z-tabpanel").find(".z-label:contains(create)").text()
      click(jq(".z-button:contains(Add)"))
      waitResponse()
      verifyTrue("you should see the 'Y' tab is added at the end of the tabs.", jq(".z-tab:contains(Y)").exists)
      verifyTrue("The create time of the 'B' tab shoud not be changed.", time == jq(".z-tabpanel").find(".z-label:contains(create)").text())
      click(jq(".z-tab:contains(Y)"))
      waitResponse()
      val ytime = jq(".z-tabpanel").find(".z-label:contains(create)").text()
      println(ytime + "/" + time)
      verifyNotEquals("its 'create time' is the latest one which is different from 'B' tab.", time, ytime)
      click(jq(".z-button:contains(Remove)"))
      waitResponse()
      click(jq(".z-tab:contains(Y)"))
      waitResponse()
      verifyTrue("the 'C' tab will be remove", !jq(".z-tab:contains(C)").exists)
      verifyTrue("the 'create time' of the 'Y' tab is the same as before.", ytime == jq(".z-tabpanel").find(".z-label:contains(create)").text())
    })
    
  }
}