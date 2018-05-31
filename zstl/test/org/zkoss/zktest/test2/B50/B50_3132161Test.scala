/* B50_3132161Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_3132161Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	Select a date and you shall see minute/seconds are both zero
	<separator/>
	<datebox id="db" width="150px"
	onChange='i.value = "" + self.value'
	format="MM/dd/yyyy HH"/>
	<separator bar="true"/>
	<label id="i"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val db = ztl$engine.$f("db")
    val i = ztl$engine.$f("i")
    runZTL(zscript, () => {
      var pattern = "\\w{3} \\w{3} \\d{2} \\d{2}:00:00 CST \\d{4}"
      click(db.$n("btn"));
      waitResponse()
      click(jq(".z-calendar-selected"))
      waitResponse()
      verifyTrue(jq("@label:eq(1)").text().matches(pattern))
    })
  }
}



