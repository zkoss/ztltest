/* B50_3192194Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_3192194Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = engine()
    val combobox = ztl$engine.$f("combobox")
    runZTL(() => {
      click(jq("@button"))
      waitResponse()
      verifyEquals("[David]", getAlertMessage())
      clickAlert()
      waitResponse()
      click(combobox.$n("btn"))
      waitResponse()
      click(jq("@comboitem:eq(2)"))
      waitResponse()
      click(jq("@button"))
      waitResponse()
      verifyEquals("[Steven]", jq(".z-window-highlighted @label").text())
    })
  }
}