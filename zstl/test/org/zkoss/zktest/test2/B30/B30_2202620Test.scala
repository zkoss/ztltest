/* B30_2202620Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2202620Test extends ZTL4ScalaTestCase {
  @Test
  def testcombobox() = {
    var zscript =
      """
			<window>
				After click
				<button id="btn" label="start" onClick="org.zkoss.zktest.test2.B2202620.start(info)"/>
				You shall see only one message (Comet received) below
				<separator/>
				<div id="info" style="border: 1px solid blue"/>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn = ztl$engine.$f("btn")
    val info = ztl$engine.$f("info")
    runZTL(zscript, () => {
      click(btn)
      // wait for comet push
      waitResponse()
      waitResponse()
      verifyEquals(1, jq("span.z-label:gt(1)").length())
      verifyEquals("Comet received", jq("span.z-label:gt(1)").text())
      verifyEquals("", jq("span.z-label:gt(2)").text())
    })
  }
}



