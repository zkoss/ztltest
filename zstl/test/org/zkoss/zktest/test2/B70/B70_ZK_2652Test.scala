package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2652.zul")
class B70_ZK_2652Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2652.zul

	Purpose:
		
	Description:
		
	History:
		Thu, Mar 12, 2015  2:58:18 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk xmlns:ca="client/attribute">
	<label multiline="true">
	1. click chosenbox
	2. scroll with mouse wheel
	3. the popup should moved with input
	</label>
    <zscript>
    ListModelList model = new ListModelList();
    model.add(1);
    model.add(2);
    model.add(3);
    </zscript>
    
    <window title='ca:data-scrollable="true"'   
        contentStyle="overflow:auto" border="normal" width="500px"
        height="300px" ca:data-scrollable="true">
        <vlayout>
            <html><![CDATA[
                Steps:
                <ol>
                    <li>Open popup of chosenbox and combobox</li>
                    <li>Scroll the window with mouse wheel.</li>
                </ol>
                
                Results:
                <ul>
                    <li style="color:red">It is a bug if the popup of the chosenbox detaches, and stays in fixed position.</li>
                    <li>This doen't happen for combobox.</li>
                </ul>
            ]]></html>

            <chosenbox width="200px" model="${model}"/>
            <combobox width="200px" model="${model}" />

            <label forEach="1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16" value="Some Text"/>
        </vlayout>
    </window>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      var chosenbox = jq("@chosenbox");
      
      click(chosenbox);
      waitResponse();
      var originTop = jq(".z-chosenbox-popup").css("top");
      verScroll(jq("@window"), 0.7);
      waitResponse();
      verifyTrue(jq(".z-chosenbox-popup").css("top") < originTop);
    })
    
  }
}