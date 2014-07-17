package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.openqa.selenium.Dimension

@Tags(tags = "B70-ZK-2308.zul")
class B70_ZK_2308Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2308.zul

	Purpose:
		
	Description:
		
	History:
		Wed, May 28, 2014  2:26:00 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
1. Using the datebox with keyboard only [ALT-DOWN] it can be closed with [ESC] or [ENTER].
<separator/>
2. After changing the date using the arrow keys, [ESC] should work as before.
<datebox/>
</zk>
"""
    runZTL(zscript,
      () => {
        // don't support ie9, ie10, ie11
        val input = jq(".z-datebox-input");
        clickAt(input, "3,2");
        waitResponse();
        
        sendKeys(input, Keys.ALT + "" + Keys.ARROW_DOWN);
        waitResponse();
        
        val popup = jq(".z-datebox-popup");
        verifyTrue("should see datebox popup.", popup.exists());
        
        sendKeys(input, Keys.ARROW_DOWN);
        waitResponse();
        sendKeys(input, Keys.ESCAPE);
        waitResponse();
        
        verifyTrue("should see datebox popup closed.", !popup.isVisible());
      })

  }
}