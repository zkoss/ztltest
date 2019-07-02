/* B50_3004412Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B50_3004412Test extends ZTL4ScalaTestCase {
  @Test
  def testzindex() = {
    val ztl$engine = engine()
    val cb = ztl$engine.$f("cb")
    val cbi = ztl$engine.$f("cbi")
    val popup = ztl$engine.$f("popup")
    runZTL(() => {
      click(cb.$n("btn"))
      waitResponse()
      mouseOver(cbi)
      sleep(1000)
      verifyTrue(jq(popup).isVisible())
      var zindex = jq(cb.$n("pp")).css("z-index")
      var ppZindex = parseInt(zindex)
      zindex = jq(popup).css("z-index")
      var popipZindex = parseInt(zindex)
      verifyTrue(popipZindex > ppZindex)
    })
  }
}



