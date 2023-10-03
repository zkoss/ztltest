/* B50_3087421Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_3087421Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = engine()
    val btn = ztl$engine.$f("btn")
    val btn1 = ztl$engine.$f("btn1")
    runZTL(() => {
      verifyFalse(btn.is("disabled"))
      doubleClick(btn)
      waitResponse()
      verifyEquals("disabled:false", getZKLog)
      verifyFalse(btn.is("disabled"))

      closeZKLog()
      verifyFalse(btn1.is("disabled"))
      doubleClick(btn1)
      waitResponse()
      verifyEquals("disabled:false", getZKLog)
      verifyFalse(btn1.is("disabled"))
    })
  }
}



