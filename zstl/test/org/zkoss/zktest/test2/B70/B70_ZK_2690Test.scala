/* B70_ZK_2690Test.scala

	Purpose:
		
	Description:
		
	History:
		Wed Oct 14 15:16:49 CST 2015, Created by chunfu

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
@Tags(tags = "B70-ZK-2690.zul")
class B70_ZK_2690Test extends ZTL4ScalaTestCase {
  def testCase() = {
    runZTL(() => {
      var grid = jq("@grid");
      nativeFrozenScroll(grid, 300);
      waitResponse()
      verifyTrue(jq(".z-auxheader").eq(1).width() < 1)
      nativeFrozenScroll(grid, -300);
      waitResponse()
      verifyTrue(jq(".z-auxheader").eq(1).width() > 1)
    })
  }
}
