/* B70_ZK_2616Test.scala

	Purpose:
		
	Description:
		
	History:
		Thu Oct  8 17:08:19 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
  *
  * @author chunfu
  */
@Tags(tags = "B70-ZK-2616.zul")
class B70_ZK_2616Test extends ZTL4ScalaTestCase {
  def testCase() = {
    runZTL(() => {
      click(jq("@button"))
      try {
        for (i <- 0 to 5) {
          click(jq("@button").eq(1))
        }
      } catch {
        case throwable =>
      }
      waitResponse()
      val window = jq(".z-window-header")
      verifyTrue(!window.exists() || window.text().equals("Session Timeout"))

    })
  }
}
