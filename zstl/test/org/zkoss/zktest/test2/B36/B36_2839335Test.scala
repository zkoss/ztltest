/* B36_2839335Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2839335Test extends ZTL4ScalaTestCase {
  @Test
  def testtype() = {
    var zscript =
      """
			<zk>
				You should not type non-number character inside the input element(Opera only)
				<timebox/>
			</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      var inp = jq("@timebox").toWidget().$n("real")
      focus(inp)
      var old = jq(inp).`val`()
      keyPress(inp, "A")
      keyPress(inp, "X")
      waitResponse()
      verifyEquals(old, jq(inp).`val`())
    })
  }
}



