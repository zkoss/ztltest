/* B85_ZK_3578Test.scala

	Purpose:

	Description:

	History:
		Wed, Nov 1, 2017 12:33:17 PM, Created by bobpeng

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags;

/**
  *
  * @author bobpeng
  */
@Tags(tags = "")
class B85_ZK_3578Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      var len = jq(".z-columns:visible:eq(0)").children().length()
      click(jq("$toggle"))
      waitResponse();
      click(jq("$toggle"))
      waitResponse();
      var lenAfter = jq(".z-columns:visible:eq(0)").children().length()
      println(len, lenAfter);
      verifyEquals("The number of columns should be the same", len, lenAfter)
    })
  }
}
