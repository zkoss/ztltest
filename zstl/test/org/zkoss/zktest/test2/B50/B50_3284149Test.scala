/* B50_3284149Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_3284149Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
			<li>Open the datebox.</li>
			<li>Click the timebox in datebox popup.</li>
			<li>The time shall not changed.</li>
		</ol>
	]]></html>
	<datebox format="yyyy-MM-dd HH:mm:ss" readonly="true"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq("@datebox").toWidget().$n("btn"))
      waitResponse()
      var inp = jq(".z-timebox").toWidget().$n("real")
      var x = jq(inp).`val`()
      focus(jq(inp))
      waitResponse()
      var x1 = jq(inp).`val`()
      verifyEquals(x, x1)
    })
  }
}



