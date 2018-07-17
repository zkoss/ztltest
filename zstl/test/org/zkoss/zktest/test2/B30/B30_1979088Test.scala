/* B30_1979088Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.util.ColorVerifingHelper


class B30_1979088Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      click(jq("@button"))
      sleep(1000)
      verifyEqualColor("red", jq(".z-paging:eq(0)").css("backgroundColor"))
      verifyEqualColor("red", jq(".z-paging:eq(1)").css("backgroundColor"))
    })
  }
}



