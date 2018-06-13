/* B50_2928044Test.java

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


class B50_2928044Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
<zk>
You can not type the words more than 3.
<textbox id="txt"  maxlength="3"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val txt = ztl$engine.$f("txt")
    runZTL(zscript, () => {
      focus(txt)
      var jq$txt = jq("$txt")
      typeKeys(jq$txt, "AAAA")
      verifyEquals(jq(jq$txt).`val`().length(), 3)
    })
  }
}



