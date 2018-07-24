/* B50_3147909Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.SeleniumOnly
import org.zkoss.ztl.unit.Widget

class B50_3147909Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val inner = ztl$engine.$f("inner")
    runZTL(() => {
      dragdropTo(jq(inner), "3,3", "10,3")
      waitResponse()
      verifyTolerant(jq(inner).height(), jq("$h").text(), 1)
      verifyTolerant(100, jq("$w").text(), 1)
    })
  }
}



