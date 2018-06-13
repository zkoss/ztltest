/* B50_3288904Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3288904Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Type '000' to the end of year (so it becomes 2011000, for example). Click outside the Datebox.</li>
			<li>The year should be capped to '200000'. If the date value become 'undefined', it is a bug.</li>
		</ol>
	]]></html>
	<zscript><![CDATA[
		import java.util.Date;
		Date d = new Date();
	]]></zscript>
	<datebox value="${d}" locale="en_US"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      var inp = jq("@datebox").toWidget().$n("real")
      focus(inp)
      sendKeys(inp, if (isSafari()) Keys.COMMAND + "" + Keys.ARROW_RIGHT else Keys.END)
      sendKeys(inp, "000")
      blur(inp)
      verifyContains(jq(inp).`val`(), "200000")
      verifyNotContains(jq(inp).`val`(), "undefined")
    })
  }
}



