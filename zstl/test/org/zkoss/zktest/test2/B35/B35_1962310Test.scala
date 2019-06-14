/* B35_1962310Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase


class B35_1962310Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      click(jq(".z-listitem-selected"))
      verifyEquals(0, jq(".z-listitem-selected").eval("index()"))
      sendKeys(jq("@listbox .z-focus-a"), Keys.DOWN)
      waitResponse()
      verifyEquals(1, jq(".z-listitem-selected").eval("index()"))
      sendKeys(jq("@listbox .z-focus-a"), Keys.DOWN)
      waitResponse()
      verifyEquals(2, jq(".z-listitem-selected").eval("index()"))
      sendKeys(jq("@listbox .z-focus-a"), Keys.UP)
      waitResponse()
      verifyEquals(1, jq(".z-listitem-selected").eval("index()"))
    })
  }
}



