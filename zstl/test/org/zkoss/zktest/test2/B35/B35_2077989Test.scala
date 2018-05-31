/* B35_2077989Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B35_2077989Test extends ZTL4ScalaTestCase {
  @Test
  def testhideWin() = {
    var zscript =
      """
			


<window id="win" title="doModal" mode="modal" minimizable="true" width="400px" height="300px">
<button id="hidebtn" label="Set Window to be invisible" onClick="win.setVisible(false)"/>
In this case, you have to test two cases as follows.
<separator/>
1. When you click the Minimize icon of the window, the window should disappeared.(That is correct)
<separator/>
2. When you click the "Set Window to be invisible" button, the window should disappeared.(That is correct)
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val hidebtn = ztl$engine.$f("hidebtn")
    runZTL(zscript, () => {
      verifyEquals(true, jq("$win").isVisible())
      click(jq("$hidebtn"))
      waitResponse()
      verifyEquals(false, jq("$win").isVisible());
    })
  }

  @Test
  def testminWin() = {
    var zscript = """$source.content"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val hidebtn = ztl$engine.$f("hidebtn")
    runZTL(zscript, () => {
      verifyEquals(true, jq("$win").isVisible())
      click(win.$n("min"))
      waitResponse()
      verifyEquals(false, jq("$win").isVisible());
    })
  }
}



