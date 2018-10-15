/* B50_2997034Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2997034Test extends ZTL4ScalaTestCase {
  @Test
  def testScroll() = {
    val ztl$engine = engine()
    val div = ztl$engine.$f("div")
    val box = ztl$engine.$f("box")
    val li1 = ztl$engine.$f("li1")
    runZTL(() => {
      /**
        * for breeze compatible , we change the specify the value ,
        * we just use the li1's position top for scroll value.
        */
      verScrollNoBodyAbs(div.$n(), jq(li1).positionTop())
      waitResponse()
      var curScrollTop = getScrollTop(div)
      curScrollTop -= 10
      verScrollNoBodyAbs(div.$n(), curScrollTop)
      waitResponse()
      click(li1.$n("cm"))
      waitResponse()
      verifyTolerant(curScrollTop, getScrollTop(div), 10)
    })
  }
}



