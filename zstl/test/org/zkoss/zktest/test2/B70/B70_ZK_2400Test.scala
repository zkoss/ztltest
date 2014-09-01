package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2400.zul")
class B70_ZK_2400Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2400.zul

	Purpose:
		
	Description:
		
	History:
		Thur, Aug 14, 2014  11:35:00 AM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<div>
		1. click up or down button. if you see the label changed as well without losing timebox's focus, it's a bug.
	</div>
    <timebox format="HH:mm" onChange="lbl.value = event.value"/>
    <separator/>
    value onChanged: <label id="lbl"/>
    <separator/>
</zk>

"""  
  runZTL(zscript,
    () => {
      val btn = jq(".z-timebox-up");
      clickAt(btn, "1,1");
      waitResponse();
      clickAt(btn, "1,1");
      waitResponse();
      verifyTrue("click up button shouldn't trigger onChange.", jq("$lbl").toWidget().get("value").equals(""));
    })
    
  }
}