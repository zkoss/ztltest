package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2590.zul")
class B70_ZK_2590Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2590.zul

	Purpose:
		
	Description:
		
	History:
		Wed, Jan 28, 2015  8:49:32 AM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. focus on combobox
	2. press 1 from numpad
	3. "1A" should be selected
	</label>
	<combobox width="150px" readonly="true" >
		<comboitem label="A1" value="A1" />
		<comboitem label="B1" value="B1" />
		<comboitem label="C1" value="C1" />
		<comboitem label="0A" value="0A" />
		<comboitem label="1A" value="1A" />
		<comboitem label="2A" value="2A" />
	</combobox>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      var input = jq(".z-combobox-input");
      sendKeys(input, "1");
      waitResponse();
      verifyTrue(input.eval("val()") == "1A");
    })
    
  }
}