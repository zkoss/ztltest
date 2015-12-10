package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2607.zul")
class B70_ZK_2607Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2607.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Feb 24, 2015  4:06:05 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
  <window border="normal" title="hello" apply="org.zkoss.zktest.test2.B70_ZK_2607">
	You should see "renderer1" in the dropdown list.
	<separator/>
	After click the "Change renderer" button, you should only see "renderer2" in the dropdown list.
    
    <selectbox id="mySelectbox"/>
  	
	<button id="btn" label="Change renderer" />
  </window>
</zk>
<<<<<<< HEAD
"""
  runZTL(zscript,
    () => {
      val btn = jq("@button")
      val options = jq(".z-selectbox option")
      verifyEquals(2, options.length())
      verifyEquals("renderer1", options.eq(0).text())
      verifyEquals("renderer1", options.eq(1).text())
      click(btn)
      waitResponse(true)
      verifyEquals(2, options.length())
      verifyEquals("renderer2", options.eq(0).text())
      verifyEquals("renderer2", options.eq(1).text())
    })
    
  }
}