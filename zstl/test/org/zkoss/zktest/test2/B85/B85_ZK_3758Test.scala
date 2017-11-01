/* B85_ZK_3758Test.scala

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
import org.zkoss.ztl.Tags;

/**
  *
  * @author bobpeng
  */
@Tags(tags = "")
class B85_ZK_3758Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      windowResizeTo(1000, 800)
      waitResponse()
      var headBtn = jq(".z-column .z-column-button").get(0)
      var prevGridHeight = jq(".z-grid").height()

      mouseOver(headBtn)
      waitResponse()
      click(headBtn)
      waitResponse()
      click(jq(".z-menuitem.z-menuitem-checkable").get(1))
      waitResponse()

      mouseOver(headBtn)
      waitResponse()
      click(headBtn)
      waitResponse()
      click(jq(".z-menuitem.z-menuitem-checkable").get(3))
      waitResponse()

      var gridHeight = jq(".z-grid").height()
      println(prevGridHeight, gridHeight)
      verifyTrue(prevGridHeight > gridHeight)
    })
  }
}
