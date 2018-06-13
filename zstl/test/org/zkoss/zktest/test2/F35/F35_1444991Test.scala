/* F35_1444991Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class F35_1444991Test extends ZTL4ScalaTestCase {
  @Test
  def testMaxAndMin() = {
    var zscript =
      """
		<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<button label="restore window" visible="false" onClick="win.minimized = !win.minimized; self.visible = win.minimized;"/>
			<window id="win" border="normal" title="Maximize and Minimize Demo" height="400px" width="350px" sizable="true" maximizable="true"
			minimizable="true" closable="true" mode="overlapped">
			 <attribute name="onMaximize">
			 if (self.maximized)
			 	alert("The window is maximized!");
			 </attribute>
			 <attribute name="onMinimize">
			 if (self.minimized) {
			 	alert("The window is minimized!");
			 	btn.visible = self.minimized;
			 }
			 </attribute>
			 Please test both maximize and minimize buttons, and then they work well.
			</window>
		</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    runZTL(zscript, () => {
      click(win.$n("max"))
      waitResponse()
      verifyEquals("The window is maximized!", getAlertMessage())
      click(jq("@window @button"))
      waitResponse()
      verifyEquals(jq("body").outerWidth(), jq(win).outerWidth())
      verifyEquals(jq("body").outerHeight(), jq(win).outerHeight())
      click(win.$n("min"))
      waitResponse()
      verifyEquals("The window is minimized!", getAlertMessage())
      click(jq("@window @button"))
      waitResponse()
      verifyFalse(isVisible(win))
    })
  }
}



