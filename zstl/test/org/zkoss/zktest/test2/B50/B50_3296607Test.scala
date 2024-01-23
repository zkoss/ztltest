/* B50_3296607Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B50_3296607Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()
      verifyEquals(2, jq(".z-errorbox").length())
      for (i <- 0 until 6) {
        verifyEquals("O", jq("@row:eq(" + i + ") td.z-row-inner:eq(0)").text())
      }
    }
    )
  }
}