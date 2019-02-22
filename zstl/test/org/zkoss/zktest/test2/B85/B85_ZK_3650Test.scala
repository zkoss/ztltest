/* B85_ZK_3650Test.scala

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
class B85_ZK_3650Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      click(jq(".z-spinner-icon.z-spinner-up").get(0))
      waitResponse()
      verifyEquals(1, jq(".z-spinner-input").`val`())
      verifyEquals(1, jq(".z-textbox").`val`())
      click(jq("body"))
      waitResponse()
      click(jq(".z-spinner-icon.z-spinner-up").get(0))
      waitResponse()
      verifyEquals(2, jq(".z-spinner-input").`val`())
      verifyEquals(2, jq(".z-textbox").`val`())
    })
  }
}
