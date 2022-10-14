/* B50_3166873Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_3166873Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = engine()
    val s1 = ztl$engine.$f("s1")
    val s2 = ztl$engine.$f("s2")
    runZTL(() => {
      var left = jq(s1).offsetLeft()
      var top = jq(s2).offsetTop()
      dragdropTo(s1, "3,3", "13,3")
      waitResponse()
      dragdropTo(s2, "3,3", "3,13")
      waitResponse()
      verifyNotEquals(left, jq(s1).offsetLeft())
      verifyNotEquals(top, jq(s2).offsetTop())
    })
  }
}



