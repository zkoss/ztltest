/* B30_1876991Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B30_1876991Test extends ZTL4ScalaTestCase {
  @Test
  def testConstraint() = {
    val ztl$engine = engine()
    val myIntbox = ztl$engine.$f("myIntbox")
    runZTL(() => {
      sendKeys(myIntbox, "100")
      waitResponse()
      blur(myIntbox)
      verifyFalse(jq(".z-errorbox").exists())

      `type`(myIntbox, "-100")
      waitResponse()
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



