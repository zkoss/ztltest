/* B50_3105728Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import java.util._

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget

class B50_3105728Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      sendKeys(jq(jq(".z-datebox").toWidget().$n("real")), "1/1")
      click(jq(".z-label"))
      var value = jq(jq(".z-datebox").toWidget().$n("real")).`val`()
      verifyContains(value, jq(jq(".z-datebox").eq(1).toWidget().$n("real")).`val`())
    })
  }
}



