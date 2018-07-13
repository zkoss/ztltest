/* B35_2077989Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2077989Test extends ZTL4ScalaTestCase {
  @Test
  def testhideWin() = {
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val hidebtn = ztl$engine.$f("hidebtn")
    runZTL(() => {
      verifyEquals(true, jq("$win").isVisible())
      click(jq("$hidebtn"))
      waitResponse()
      verifyEquals(false, jq("$win").isVisible());
    })
  }
  @Test
  def testminWin() = {
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    val hidebtn = ztl$engine.$f("hidebtn")
    runZTL(() => {
      verifyEquals(true, jq("$win").isVisible())
      click(win.$n("min"))
      waitResponse()
      verifyEquals(false, jq("$win").isVisible());
    })
  }
}



