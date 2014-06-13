package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys

@Tags(tags = "B70-ZK-2306.zul")
class B70_ZK_2306Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2306.zul

	Purpose:
		
	Description:
		
	History:
		Thu, May 22, 2014  4:09:59 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<div height="1200px">scroll down to click the datebox and use keyboard to navigate the calendar with UP and DOWN, the browser's scrollbar won't be moved.</div>
	<datebox/>
</zk>
"""  
  runZTL(zscript,
    () => {
      // the datebox only shows moment after click
      // didn't work in ff
      click(jq(".z-datebox-button"))
      waitResponse()
      val scrollTop = jq("body").scrollTop();
      val target = jq(".z-datebox-input");
      sendKeys(target, Keys.DOWN)
      sendKeys(target, Keys.DOWN)
      sendKeys(target, Keys.UP)
      verifyTrue("browser's scrollbar shouldn't move.", scrollTop == jq("body").scrollTop())
    })
    
  }
}