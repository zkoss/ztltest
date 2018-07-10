/* B36_2710830Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2710830Test extends ZTL4ScalaTestCase {
  @Test
  def testposition() = {
    runZTL(() => {
      click("@button")
      waitResponse()
      verifyEquals("true", getZKLog())
    })
  }
}



