/* B35_2086352Test.java

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


class B35_2086352Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	1. Click "doHighlighted" button.
	<separator />
	2. Minimize window.
	<separator />
	3. If the mask still appears, that is wrong.
	<button onClick="win.doHighlighted()" label="doHighlighted" />

	<window id="win" title="Window Component" width="300px" minimizable="true"
		border="normal">
	</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    runZTL(zscript, () => {
      verifyFalse(win.$n("mask").exists())
      click(jq("@button"))
      waitResponse()
      verifyTrue(win.$n("mask").exists())
      click(win.$n("min"))
      waitResponse()
      verifyTrue(win.$n("mask").exists())
      verifyFalse(jq(win.$n("mask")).isVisible())
    })
  }
}



