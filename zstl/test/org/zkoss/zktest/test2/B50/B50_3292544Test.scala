/* B50_3292544Test.java

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


class B50_3292544Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Type 0.5 in the Doublespinner and click on somewhere else. If you can't type in the decimal sign ".", it is a bug.</li>
		</ol>
	]]></html>
	<doublespinner step="0.5" />
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      var input = jq("@doublespinner").toWidget().$n("real")
      focus(input)
      sendKeys(input, "0")
      sendKeys(input, ".")
      sendKeys(input, "5")
      blur(input)
      verifyEquals("0.5", input.attr("value"))
    })
  }
}



