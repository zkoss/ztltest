/* B35_2515562Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B35_2515562Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      click(jq(jq(".z-datebox").toWidget().$n("btn")))
      verifyEqualColor("yellow", jq(".z-calendar-text").css("color"))
    })
  }
}