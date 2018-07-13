/* B50_3000987Test.java

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


class B50_3000987Test extends ZTL4ScalaTestCase {
  @Test
  def testChangeLabel() = {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()
      verifyEquals("D", jq("@option:eq(2)").text())
    })
  }
}



