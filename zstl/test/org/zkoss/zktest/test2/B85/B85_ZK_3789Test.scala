/* B85_ZK_3789Test.scala

	Purpose:

	Description:

	History:
		Tue, Nov 7, 2017 12:33:17 PM, Created by bobpeng

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
class B85_ZK_3789Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      click(jq("a.z-bandbox-button").get(0))
      waitResponse()
      verifyNotEquals("Error popped.", "fail", getZKLog())
    })
  }
}
