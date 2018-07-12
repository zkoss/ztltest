/* B30_2080346Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2080346Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      var inp = jq("@combobox").toWidget().$n("real")
      focus(inp)
      typeKeys(inp, "a")
      blur(inp)
      waitResponse()
      verifyEquals("aa", jq("$copy").`val`())
    })
  }
}



