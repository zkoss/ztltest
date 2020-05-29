/* B50_ZK_424Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_ZK_424Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = engine()
    val msg = ztl$engine.$f("msg")
    runZTL(() => {
      verifyEquals("111", msg.$n().attr("innerHTML"))
    })
  }
}



