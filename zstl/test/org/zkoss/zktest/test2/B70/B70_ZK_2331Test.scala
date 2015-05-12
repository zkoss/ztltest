package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2331.zul")
class B70_ZK_2331Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2331.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jun 18, 2014  16:55:12 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<vbox>
	<div style="height: 1000px;">
		1. ensure that the content is large than viewport.
		<separator></separator>
		2. click combobox at the bottom. if popup overlaps the input, it's a bug. 
	</div>
	<groupbox>
		<panel style="height:400px">
			<panelchildren>
				<div style="height: 350px;"></div>
				<combobox id="cmbColor">
					<comboitem label="testA" height="25px"/>
					<comboitem label="testB" height="25px"/>
					<comboitem label="testC" height="25px"/>
					<comboitem label="testD" height="25px"/>
				</combobox>
			</panelchildren>
		</panel>
	</groupbox>
</vbox>

"""  
  runZTL(zscript,
    () => {
      click(jq(".z-combobox-button"));
      waitResponse();
      val popup = jq(".z-combobox-popup");
      verifyTrue("popup shouldn't overlap the input.", popup.offsetTop() + popup.height() < jq("@combobox").offsetTop());
    })
    
  }
}