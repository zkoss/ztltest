package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2687.zul")
class B70_ZK_2687Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2687.zul

	Purpose:

	Description:

	History:
		Tue Jun  9 16:56:25 CST 2015, Created by chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<label multiline="true">
	1. click either chk or txt button
	2. it will scroll to bottom and show notification to corresponding component.
	</label>
	<div>
    	<button label="txt" onClick='Clients.scrollIntoView(txt);
    		Clients.showNotification("txt", txt);' />
   		<button label="chk" onClick='Clients.scrollIntoView(chk);
   		Clients.showNotification("chk", chk);' />
   	</div>
    <div height="300px" style="overflow:auto">
    	<vlayout spacing="30px">
            <div height="350px"></div>
            <textbox id="txt" />
            <checkbox id="chk" />
        </vlayout>
   </div>
</zk>
    
"""
    runZTL(zscript,
      () => {
        val btns = jq("@button")
        click(btns.get(0))
        waitResponse()
        var content = jq(".z-notification-content").last().text()
        verifyEquals("txt", content)
        click(btns.get(1))
        waitResponse()
        content = jq(".z-notification-content").last().text()
        verifyEquals("chk", content)
      })

  }
}