/* B30_2086020Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase

class B30_2086020Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      val inp = widget("@combobox").$n("real")
      click(jq(inp))
      typeKeys(jq(inp), "aa")
      sendKeys(jq(inp), Keys.ENTER)
      waitResponse()
      verifyEquals("aa", jq("$copy").`val`())
    })
  }
}



