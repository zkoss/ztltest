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
      windowResizeTo(600, 800)
      waitResponse()
      val listbox = jq(".z-listbox")
      nativeFrozenScroll(listbox, 100)
      waitResponse()
      nativeFrozenScroll(listbox, 0)
      waitResponse()
      windowResizeTo(800, 800)
      waitResponse()
      var headers = jq(".z-listheader")
      val w1 = headers.eq(0).outerWidth()
      val w2 = headers.eq(1).outerWidth()
      val w3 = headers.eq(2).outerWidth()
      nativeFrozenScroll(listbox, 100)
      waitResponse()
      nativeFrozenScroll(listbox, 0)
      waitResponse()
      headers = jq(".z-listheader")
      verifyTolerant(w1, headers.eq(0).outerWidth(), 2)
      verifyTolerant(w2, headers.eq(1).outerWidth(), 2)
      verifyTolerant(w3, headers.eq(2).outerWidth(), 2)
    })
  }
}
