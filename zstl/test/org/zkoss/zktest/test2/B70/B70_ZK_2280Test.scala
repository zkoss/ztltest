package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys

@Tags(tags = "B70-ZK-2280.zul")
class B70_ZK_2280Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2280.zul

	Purpose:
		
	Description:
		
	History:
		Wed, May 07, 2014  5:06:20 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<paging id="pag" width="500px" pageSize="10" totalSize="12" sclass="floatright" pageIncrement="1" detailed="true" onPaging=""/>
	Please click the following buttons, and the detail text of the paging bar at the right side will be updated.
	<button id="plus" onClick="pag.setTotalSize(pag.getTotalSize() + 1);" label="+"/>
	<button id="minus" onClick="pag.setTotalSize(pag.getTotalSize() - 1);" label="-"/>
</zk>
"""  
  runZTL(zscript,
    () => {
      val plus = jq("$plus");
      val minus = jq("$minus");
      
      click(plus);
      waitResponse();
      click(minus);
      waitResponse();
      click(minus);
      waitResponse();

      verifyTrue("the detail text of the paging bar should be updated", jq("@paging").toWidget().get("TotalSize") == "11");
    })
    
  }
}