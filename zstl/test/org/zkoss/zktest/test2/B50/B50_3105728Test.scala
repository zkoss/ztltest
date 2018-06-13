/* B50_3105728Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import java.util._

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget

class B50_3105728Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Enter "1/1" in the datebox and click outside of the datebox.</li>
			<li>You should see the date become Jan 1st of the CURRENT year. If not, there is a bug.</li>
		</ol>
	]]></html>
	<datebox width="300px" format="MM/dd/yyyy, HH:mm:ss.SSS" />
	<label id="outer" value="outer area" />
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val outer = ztl$engine.$f("outer")
    runZTL(zscript, () => {
      sendKeys(jq(jq(".z-datebox").toWidget().$n("real")), "1/1")
      click(jq(".z-label"))
      var value = jq(jq(".z-datebox").toWidget().$n("real")).`val`()
      var sdf = new java.text.SimpleDateFormat("MM/dd/yyyy, HH:mm:ss.SSS")
      var year = 0
      try {
        var cal: Calendar = java.util.Calendar.getInstance()
        cal.setTime(sdf.parse(value))
        year = cal.get(Calendar.YEAR)
      } catch {
        case e: java.text.ParseException => {
          verifyTrue(e.getMessage(), false)
        }
      }
      verifyTrue("year cannot be less than 2010", year > 2010)
    })
  }
}



