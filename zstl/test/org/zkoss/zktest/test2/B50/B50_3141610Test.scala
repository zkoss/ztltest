/* B50_3141610Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3141610Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      val cb = jq("@checkbox").toWidget;
      val menubar = jq("@menubar").toWidget;
      verifyFalse(isVisible(menubar.$n("right")))
      verifyFalse(isVisible(menubar.$n("left")))
      click(cb.$n("real"))
      waitResponse();
      verifyTrue(isVisible(menubar.$n("right")))
      verifyTrue(isVisible(menubar.$n("left")))
    })
  }
}



