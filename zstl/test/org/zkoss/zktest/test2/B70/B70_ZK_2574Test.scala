package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2574.zul")
class B70_ZK_2574Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2574.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Feb 24, 2015  5:06:58 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	Please click the following two buttons, you should see "started" and then "finished". (Servlet 3.0 only)
	<div apply="org.zkoss.zktest.test2.B70_ZK_2574">
	<button id="btn" label="start (Generic Approach)"/>
	<button id="btn2" label="start (Simpler Approach)"/>
	<label id="status"/>
	</div>
</zk>
    
"""  
  runZTL(zscript,
    () => {
      var btn = jq("$btn");
      var btn2 = jq("$btn2");
      var status = jq("$status");
      click(btn);
      waitResponse();
      verifyEquals("start", status);
      sleep(2000);
      verifyEquals("finished", status);
      
      click(btn2);
      waitResponse();
      verifyEquals("start", status);
      sleep(2000);
      verifyEquals("finished", status);
    })
    
  }
}