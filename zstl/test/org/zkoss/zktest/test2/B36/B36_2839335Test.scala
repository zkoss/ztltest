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


class B36_2839335Test extends ZTL4ScalaTestCase {
  @Test
  def testtype() = {
    runZTL(() => {
      val inp = jq("@timebox").toWidget().$n("real")
      click(inp)
      evalScript(zk(inp) + ".setSelectionRange(0,0)")
      waitResponse()
      val old = jq(inp).`val`()
      sendKeys(inp, "A")
      sendKeys(inp, "X")
      waitResponse()
      verifyEquals(old, jq(inp).`val`())
    })
  }
}



