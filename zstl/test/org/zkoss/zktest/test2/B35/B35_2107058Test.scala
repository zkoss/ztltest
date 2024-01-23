/* B35_2107058Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase


class B35_2107058Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      sendKeys(jq("$username"), "hello")
      waitResponse()
      sendKeys(jq("$password"), "world")
      waitResponse()
      click(jq("$btn"))
      waitResponse()
      verifyEquals("Login button clicked", jq(".z-window-highlighted .z-label").text())
      click(jq(".z-messagebox-button"))
      waitResponse()
      focus(jq("$password"))
      sendKeys(jq("$password"), Keys.ENTER)
      waitResponse()
      verifyEquals("Window.onOK triggered, password=world", jq(".z-window-highlighted .z-label").text())
    })
  }
}