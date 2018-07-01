/* B85_ZK_3516Test.scala

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
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

/**
  *
  * @author bobpeng
  */
@Tags(tags = "")
@IgnoreBrowsers("chrome,ff")
class B85_ZK_3516Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      var wSplitter = jq(".z-splitter-outer").width()

      windowResizeTo(200, 800)
      waitResponse()
      verify(wSplitter)

      windowResizeTo(1400, 800)
      waitResponse()
      verify(wSplitter)

      windowResizeTo(1100, 800)
      waitResponse()
      verify(wSplitter)

      windowResizeTo(1100, 600)
      waitResponse()
      verify(wSplitter)

      windowResizeTo(1100, 400)
      waitResponse()
      verify(wSplitter)
    })
  }

  def verify(wSplitter: Int) = {
    verifyEquals(wSplitter, jq(".z-splitter-outer").width())
    verifyEquals(jq(".z-div:eq(1)").width(), jq(".z-hbox").width())
  }
}
