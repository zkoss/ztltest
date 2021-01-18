/* B50_3288904Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_3288904Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      var inp = jq("@datebox").toWidget().$n("real")
      focus(inp)
      sendKeys(inp, Keys.END)
      sendKeys(inp, "000")
      blur(inp)
      verifyContains(jq(inp).`val`(), "200000")
      verifyNotContains(jq(inp).`val`(), "undefined")
    })
  }
}



