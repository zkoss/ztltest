/* B50_2956449Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50;

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_2956449Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    runZTL(() => {
      focus(jq("$tb"))
      sendKeys(jq("$tb"), Keys.UP)
      waitResponse()
      verifyEquals("38", jq("$l").text())
      focus(jq("$tb"))
      sendKeys(jq("$tb"), Keys.DOWN)
      waitResponse()
      verifyEquals("40", jq("$l").text())
    })
  }
}



