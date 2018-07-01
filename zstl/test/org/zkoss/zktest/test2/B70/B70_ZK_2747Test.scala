/* B70_ZK_2720Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct  7 16:49:43 CST 2015, Created by chunfu

Copyright (C)  2015 Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;

/**
  *
  * @author chunfu
  */
@Tags(tags = "")
class B70_ZK_2747Test extends ZTL4ScalaTestCase {
  def testCase() = {
    runZTL(() => {
      verifyTrue(jq("#zk_showBusy").exists())
      sleep(3000)
      verifyTrue(!jq("#zk_showBusy").exists())

    })
  }
}
