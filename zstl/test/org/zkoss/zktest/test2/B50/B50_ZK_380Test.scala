/* B50_ZK_380Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_ZK_380Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      val ztl$engine = engine()
      val i1 = ztl$engine.$f("i1")
      val i2 = ztl$engine.$f("i2")
      val l1 = ztl$engine.$f("l1")
      val l2 = ztl$engine.$f("l2")
      verifyNotEquals("hidden", i1.$n("cm").attr("style.visibility"))
      verifyEquals("hidden", i2.$n("cm").attr("style.visibility"))
      click(i1)
      waitResponse()
      click(i2)
      waitResponse()
      verifyEquals("true", getText(l1))
      verifyEquals("false", getText(l2))
    })
  }
}