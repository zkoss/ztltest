/* B50_3168509Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_3168509Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Click on the datebox button to open the Calendar.</li>
			<li>Select 1/1/2001. If you see a date value other than 01/01/2001, it's a bug.</li>
			<li>Refresh the page and select 1/2/2001. You should see 01/02/2001. Otherwise it's a bug.</li>
		</ol>
	]]></html>
	<datebox id="db" format="MM/dd/yyyy" text="12/31/2000" />
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val db = ztl$engine.$f("db")
    runZTL(zscript, () => {
      click(db.$n("btn"))
      waitResponse()
      click(jq(".z-calendar-selected").next())
      waitResponse()
      verifyEquals("01/01/2001", jq(jq(".z-datebox").toWidget().$n("real")).`val`())
      click(db.$n("btn"))
      waitResponse()
      click(jq(".z-calendar-selected").next())
      waitResponse()
      verifyEquals("01/02/2001", jq(jq(".z-datebox").toWidget().$n("real")).`val`())
    })
  }

  @Test
  def testztl1() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Click on the datebox button to open the Calendar.</li>
			<li>Select 1/1/2001. If you see a date value other than 01/01/2001, it's a bug.</li>
			<li>Refresh the page and select 1/2/2001. You should see 01/02/2001. Otherwise it's a bug.</li>
		</ol>
	]]></html>
	<datebox id="db" format="MM/dd/yyyy" text="12/31/2000" />
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val db = ztl$engine.$f("db")
    runZTL(zscript, () => {
      click(db.$n("btn"))
      waitResponse()
      var right = jq(".z-calendar").toWidget().$n("right")
      click(right)
      waitResponse()
      sleep(500)
      click(jq(".z-calendar-cell.z-calendar-weekday:contains(2):eq(0)"))
      waitResponse()
      verifyEquals("01/02/2001", jq(jq(".z-datebox").toWidget().$n("real")).`val`())
    })
  }
}



