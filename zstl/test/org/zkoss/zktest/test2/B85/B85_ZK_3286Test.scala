/* B85_ZK_3286Test.scala

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
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  *
  * @author bobpeng
  */
@Tags(tags = "")
@IgnoreBrowsers("ie9")
class B85_ZK_3286Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      click(jq(".z-datebox-button").get(0))
      waitResponse()
      var date = jq(".z-calendar-cell.z-calendar-weekday:eq(15)")
      mouseOver(date)
      waitResponse()
      click(date)
      waitResponse()
      sleep(2000)
      verifyNotEquals("", jq(".z-datebox-input").`val`())
    })
  }
}
