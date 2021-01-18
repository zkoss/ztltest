/* B50_3292544Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B50_3292544Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      var input = jq("@doublespinner").toWidget().$n("real")
      click(input)
      typeKeys(input, "0.5")
      blur(input)
      verifyEquals("0.5", input.attr("value"))
    })
  }
}



