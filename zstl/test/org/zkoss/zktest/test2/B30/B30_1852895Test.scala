/* B30_1852895Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B30_1852895Test extends ZTL4ScalaTestCase {
  @Test
  def testItemValue() = {
    runZTL(() => {
      click(jq(jq(".z-combobox").toWidget().$n("btn")))
      waitResponse()
      click(jq(".z-comboitem:eq(0)"))
      waitResponse()
      click(jq(".z-button"))
      waitResponse()
      verifyContains(jq(".z-messagebox .z-label").text(), "1")
    })
  }
}



