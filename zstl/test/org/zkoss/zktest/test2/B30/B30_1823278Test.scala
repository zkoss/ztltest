/* B30_1823278Test.java

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


class B30_1823278Test extends ZTL4ScalaTestCase {
  @Test
  def testKeyDownUp() = {
    val ztl$engine = engine()
    val listbox = ztl$engine.$f("listbox")
    runZTL(() => {
      click(jq(".z-listitem:eq(0)"))
      waitResponse()
      for (_ <- 0 until 15) {
        sendKeys(jq(listbox).find(".z-focus-a"), Keys.DOWN)
        sleep(30)
      }
      var scrollTop = parseInt(listbox.$n("body").attr("scrollTop"))
      verifyTrue("Times of pressing Down: 15, scrollTop: " + scrollTop, 150 < scrollTop)
      for (_ <- 0 until 15) {
        sendKeys(jq(listbox).find(".z-focus-a"), Keys.UP)
        sleep(30)
      }
      scrollTop = parseInt(listbox.$n("body").attr("scrollTop"))
      verifyTrue("Times of pressing Down: 15, scrollTop: " + scrollTop, 3 > scrollTop)
    })
  }
}



