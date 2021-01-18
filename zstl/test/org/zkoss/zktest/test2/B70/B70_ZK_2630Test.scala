/* B70_ZK_2630Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct  7 17:18:38 CST 2015, Created by chunfu

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
class B70_ZK_2630Test extends ZTL4ScalaTestCase {
  def testCase() = {
    runZTL(() => {
      verifyTolerant(jq(".z-window-close").offsetTop(), jq(".z-caption-content").offsetTop(), 1)
    })
  }
}
