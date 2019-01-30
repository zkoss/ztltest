/* B50_3251564Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3251564Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = engine()
    runZTL(() => {
      var x = jq("@textbox").offsetLeft()
      typeKeys(jq("@textbox"), "")
      waitResponse()
      sendKeys(jq("@textbox"), Keys.TAB)
      waitResponse()
      verifyTrue(jq(".z-errorbox").exists())
      var y = jq(".z-errorbox").positionLeft()
      var y1 = jq(".z-errorbox").outerWidth()
      verifyTrue(x > y)
      verifyTolerant(x - y1, y, 1)
    })
  }
}



