/* B36_2818308Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B36_2818308Test extends ZTL4ScalaTestCase {
  @Test
  def testscrollIntoView() = {
    val ztl$engine = engine()
    val tree = ztl$engine.$f("tree")
    runZTL(() => {
      var body = jq(tree.$n("body"))
      var table = body.find("table")
      click(jq("@button[label=\"add under bottom\"]"))
      waitResponse()
      var scrollTop = getScrollTop(tree)
      verifyTolerant(215, scrollTop, 10)
      click(jq("@button[label=\"add under bottom\"]"))
      waitResponse()
      scrollTop = getScrollTop(tree)
      verifyTolerant(260, scrollTop, 10)
      click(jq("@button[label=\"add upon top\"]"))
      waitResponse()
      click(jq("@button[label=\"add upon top\"]"))
      waitResponse()
      verifyEquals(0, getScrollTop(tree))
    })
  }
}



