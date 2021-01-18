/* B50_3097181Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

@IgnoreBrowsers("ios,android")
class B50_3097181Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      mouseOver(jq(".z-menu:eq(0)").toWidget().$n("a"))
      waitResponse()
      mouseOver(jq(".z-menu:eq(1)").toWidget().$n("a"))
      waitResponse()
      verifyTrue(isVisible(jq(".z-colorpalette")))
      mouseOver(jq(".z-colorpalette-color:eq(8)"))
      verifyTrue(isVisible(jq(".z-colorpalette")))
      mouseOver(jq(".z-colorpalette-color:eq(18)"))
      verifyTrue(isVisible(jq(".z-colorpalette")))
      mouseOver(jq(".z-colorpalette-color:eq(28)"))
      verifyTrue(isVisible(jq(".z-colorpalette")))
    })
  }
}



