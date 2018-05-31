/* B50_3024208Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_3024208Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
<html>
<![CDATA[
<ol>
	<li>Check that the icon of datebox button does not move up when mouseover</li>
</ol>
]]>
</html>
<datebox id="d"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val d = ztl$engine.$f("d")
    runZTL(zscript, () => {
      var x = getElementPositionTop(d.$n("btn")).intValue()
      mouseOver(d.$n("btn"))
      sleep(500)
      var x1 = getElementPositionTop(d.$n("btn")).intValue()
      verifyEquals(x, x1)
    })
  }
}



