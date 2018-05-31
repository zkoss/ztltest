package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2827.zul")
class B70_ZK_2827Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2827.zul

	Purpose:
		
	Description:
		
	History:
		Mon Aug  3 09:52:49 CST 2015, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<div apply="org.zkoss.zktest.test2.B70_ZK_2827">
		<button id="addContainer" label="Click Me"/>
	</div>
</zk>

"""
    runZTL(zscript,
      () => {
        //click the 1st button
        click(jq("$addContainer"))
        waitResponse()
        //click the 2nd button (just added by clicking the 1st button)
        click(jq("button").eq(1))
        waitResponse()
        //bug is fixed if there are no error
        verifyFalse(hasError())
      })
  }
}