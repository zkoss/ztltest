package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1113.zul")
class B60_ZK_1113Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<!--
B60-ZK-1113.zul

	Purpose:
		
	Description:
		
	History:
		Mon, May 6, 2012 09:56:17 AM, Created by vincent

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
-->
<zk>
	<window id="win" apply="org.zkoss.zktest.test2.B60_ZK_1113_Composer">
		<div>
		1. ZK EE only
		2. open chosenbox and press 'ESC' key
		3. you should see nothing
		</div>
		<chosenbox id="cbx" width="500px" model="${win$composer.getModel()}" emptyMessage="------------------"/>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        val cb = jq(".z-chosenbox")
        click(cb)
        waitResponse()
        sendKeys(cb.toWidget().$n("inp"), Keys.ESCAPE)
        waitResponse()
        verifyTrue("you should see nothing", !cb.exists)
      })

  }
}