/* B30_1760140Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1760140Test extends ZTL4ScalaTestCase {
  @Test
  def testDragdrop() = {
    var zscript =
      """
		<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:p>I've tested and discover a bug in the comboitems when the combobox is
		placed inside an overlapped window.
		
		When you drag the overlapped window within your screen with the items of
		the combobox shown, these items remains in the same place instead of moving
		with the window.</n:p>
			<window id="win" mode="overlapped" border="normal" width="350px"
			sizable="true">
			<caption label="Hi there!"/>
			<combobox id="cb">
			<comboitem label="Simple and Rich"/>
			<comboitem label="Cool!"/>
			<comboitem label="Thumbs Up!"/>
			</combobox>
		</window>
		</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      click(cb.$n("btn"))
      verifyTrue(isVisible(cb.$n("pp")))
      waitResponse()
      dragdropTo(jq("@window").toWidget().$n("cap"), "10,10", "160,160")
      verifyFalse(isVisible(cb.$n("pp")))
    })
  }
}



