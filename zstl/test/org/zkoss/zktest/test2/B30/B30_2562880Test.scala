/* B30_2562880Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B30_2562880Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val lh = jq(".z-listheader")
    val popup = jq(".z-menupopup")
    runZTL(() => {
      clickAt(jq(".z-listcell"), "2,2")
      waitResponse()
      verifyTrue(isVisible(popup))
      clickAt(lh.toWidget.$n("cave"), "2,2")
      waitResponse()
      verifyFalse(isVisible(popup))
    })
  }
}



