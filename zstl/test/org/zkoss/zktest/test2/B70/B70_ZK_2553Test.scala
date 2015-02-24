package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2553.zul")
class B70_ZK_2553Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2553.zul

	Purpose:
		
	Description:
		
	History:
		Mon, Jan 26, 2015  2:27:19 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. load this page without js error
	</label>
	<grid>
		<frozen columns="1"/>
		<columns>
			
		</columns>
		<rows>
		</rows>
	</grid>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      var errbox = jq(".z-error");
      verifyTrue(!errbox.isVisible());
    })
    
  }
}