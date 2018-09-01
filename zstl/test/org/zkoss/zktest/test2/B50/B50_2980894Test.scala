/* B50_2980894Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2980894Test extends ZTL4ScalaTestCase {
  @Test
  def testselectDate() = {
    var zscript =
      """
			<datebox id="db" readonly="true" />
		"""
    val ztl$engine = engine()
    val db = ztl$engine.$f("db")
    runZTL(zscript, () => {
      click(db.$n("btn"))
      waitResponse()
      var cal = jq(db.$n("pp").firstChild()).toWidget
      click(cal.$n("ty"))
      waitResponse()
      var mid = cal.$n("mid")
      verifyContains(mid.attr("className"), "z-calendar-year")
      click(cal.$n("y0"))
      waitResponse()
      verifyContains(mid.attr("className"), "z-calendar-mon")
      click(cal.$n("m0"))
      waitResponse()
      verifyContains(mid.attr("className"), "z-calendar-body")
    })
  }
}



