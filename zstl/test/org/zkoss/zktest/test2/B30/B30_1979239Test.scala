/* B30_1979239Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

@IgnoreBrowsers("ios,android")
class B30_1979239Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      mouseOver(jq(".z-menu").toWidget().$n("a"));
      sleep(500)
      mouseOver(jq(".z-menuitem"));
      sleep(2000)
      verifyTrue(jq(".z-popup").exists())
      verifyTrue(jq(".z-popup").isVisible())
    })
  }
}
