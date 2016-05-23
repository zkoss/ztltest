package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2635.zul")
class B70_ZK_2635Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2635.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Mar 03, 2015 11:18:06 AM, Created by JamesChu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
		1.hover on the icon
		2.click "one"
		3.the position should not move
	</label>
	<navbar orient="vertical" width="50px" collapsed="true">
		<nav label="Get Started" iconSclass="z-icon-th-list">
			<navitem label="One"/>
			<navitem label="Two"/>
		</nav>
	</navbar>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      mouseMoveAt(jq(".z-navbar").first, "10,10")
      waitResponse()
      click(jq(".z-nav").first)
      waitResponse()
      val left = jq(".z-nav-popup").css("left")
      click(jq(".z-navitem").first)
      waitResponse()
      verifyEquals(jq(".z-nav-popup").css("left"), left)
    })
    
  }
}