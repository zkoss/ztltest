/* B35_2078163Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2078163Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()
      click(jq(".z-spinner").toWidget().$n("btn-up"))
      waitResponse()
      verifyEquals(3, jq(".z-spinner").toWidget().$n("real").attr("value"))
    })
  }
}



