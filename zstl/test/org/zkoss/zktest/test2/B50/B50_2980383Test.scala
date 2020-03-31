/* B50_2980383Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_2980383Test extends ZTL4ScalaTestCase {
  @Test
  def testTabscroll() = {
    val ztl$engine = engine()
    val tabs = ztl$engine.$f("tabs")
    val last = ztl$engine.$f("last")
    runZTL(() => {
      waitResponse(true)
      var header = tabs.$n()
      var tab = last.$n()
      // one px tolerant would be ok .
      verifyTolerant(parseInt(header.attr("scrollLeft")) + parseInt(header.attr("offsetWidth")),
        parseInt(tab.attr("offsetLeft")) + parseInt(tab.attr("offsetWidth")), 1)
    })
  }
}



