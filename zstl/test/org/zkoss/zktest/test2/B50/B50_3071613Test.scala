/* B50_3071613Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B50_3071613Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = engine()
    runZTL(() => {
      var box = jq("@decimalbox")
      typeKeys(box, "12.123")
      waitResponse()
      blur(box)
      waitResponse()
      verifyEquals("12.12", box.`val`())
      box.toWidget().toElement().set("value", "")
      waitResponse()
      typeKeys(box, "12.125")
      waitResponse()
      blur(box)
      waitResponse()
      verifyEquals("12.13", box.`val`())
    })
  }
}



