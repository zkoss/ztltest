/* B50_3006313Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_3006313Test extends ZTL4ScalaTestCase {
  @Test
  def testSliderGetCurpos() = {
    val ztl$engine = engine()
    val sld = ztl$engine.$f("sld")
    val btn1 = ztl$engine.$f("btn1")
    val ib1 = ztl$engine.$f("ib1")
    val ib2 = ztl$engine.$f("ib2")
    runZTL(() => {
      dragdropTo(sld.$n("btn"), "0,0", "50,0")
      waitResponse()
      click(btn1)
      waitResponse()
      verifyNotEquals(50, parseInt(jq(ib2).`val`()))
      verifyEquals(parseInt(jq(ib1).`val`()), parseInt(jq(ib2).`val`()))
    })
  }
}



