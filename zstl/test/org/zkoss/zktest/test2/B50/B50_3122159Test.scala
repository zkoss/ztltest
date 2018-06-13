/* B50_3122159Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import java.util._

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget

class B50_3122159Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
Please click upon the date icon to choose a date and it should immediately alert a dialog to display a date that you selected.
<datebox id="dt" onChange="alert(self.value)"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val dt = ztl$engine.$f("dt")
    runZTL(zscript, () => {
      var cal = Calendar.getInstance()
      var year = cal.get(Calendar.YEAR)
      click(dt.$n("btn"))
      waitResponse()
      click(jq(".z-calendar-selected"))
      waitResponse()
      verifyContains(getAlertMessage() + "00:00:00 CST " + year, jq(".z-calendar-selected").text())
    })
  }
}



