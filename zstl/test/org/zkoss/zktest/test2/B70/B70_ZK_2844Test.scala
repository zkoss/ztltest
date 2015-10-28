package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2844.zul")
class B70_ZK_2844Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2844.zul

	Purpose:
		
	Description:
		
	History:
		Wed Aug 19 11:26:29 CST 2015, Created by jumperchen

Copyright (C) 2015 Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. Please click the "redirect stops client engine" button.
	2. Click the "test AU" button, and then you should be able to see "au working" message at zk log area.
	</label>
	<button label="redirect stops client engine" onClick='Executions.getCurrent().sendRedirect("whatever", "_blank");'/>
	<button label="test AU" onClick='Clients.log("au working")'/>
</zk>

"""  
  runZTL(zscript,
    () => {
      //click the left button
      click(jq("button").eq(0))
      waitResponse()
      switchTab()
      //click the right button
      click(jq("button").eq(1))
      waitResponse()
      //check message in zk.log is "au working"
      verifyEquals("au working\n", getZKLog())
    })
  }
}