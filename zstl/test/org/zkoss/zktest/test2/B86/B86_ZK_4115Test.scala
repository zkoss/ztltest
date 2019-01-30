/* B86_ZK_4115Test.java

        Purpose:

        Description:

        History:
           Tue Dec 04 17:25:14 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B86_ZK_4115Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      var listbox = jq(".z-listbox")
      frozenScroll(listbox, 1)
      waitResponse()
      frozenScroll(listbox, 0)
      waitResponse()
      windowResizeTo(getWindowWidth + 100, getWindowHeight)
      waitResponse()
      var headers = jq(".z-listheader")
      var w1 = headers.eq(0).outerWidth()
      var w2 = headers.eq(1).outerWidth()
      var w3 = headers.eq(2).outerWidth()

      frozenScroll(listbox, 1)
      waitResponse()
      frozenScroll(listbox, 0)
      waitResponse()
      headers = jq(".z-listheader")
      verifyTolerant(w1, headers.eq(0).outerWidth(), 2)
      verifyTolerant(w2, headers.eq(1).outerWidth(), 2)
      verifyTolerant(w3, headers.eq(2).outerWidth(), 2)
    })
  }
}
