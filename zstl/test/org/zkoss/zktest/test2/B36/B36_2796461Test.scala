/* B36_2796461Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2796461Test extends ZTL4ScalaTestCase {
  @Test
  def testpopup() = {
    var zscript =
      """
			<zk>
			<style>
			.z-calendar {
				width: 360px;
			}
			.z-calendar-cell {
			   font-size: 20px;
			}
			</style>
			Please press the icon on the right of the box, and then the popup should not appear with a scroll bar.
			<datebox id="db"/>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val db = ztl$engine.$f("db")
    runZTL(zscript, () => {
      click(db.$n("btn"))
      waitResponse()
      var pp = db.$n("pp")
      verifyTolerant(parseInt(pp.attr("scrollHeight")), jq(pp).outerHeight(), 6)
    })
  }
}



