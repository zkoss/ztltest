/* B30_1579515Test.java

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


class B30_1579515Test extends ZTL4ScalaTestCase {
  @Test
  def testRightClick() = {
    var zscript =
      """
			<window id="win" context="menu" border="normal" contentStyle="background-color:blue">
				<menupopup id="menu">
					<menu label="Save"/>
				</menupopup> 
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val menu = ztl$engine.$f("menu")
    runZTL(zscript, () => {
      contextMenu(win)
      waitResponse();
      verifyTrue(isVisible(menu))
    })
  }
}



