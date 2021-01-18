/* B85_ZK_3583Test.java

        Purpose:

        Description:

        History:
                Thu Mar 15 12:32:39 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

@IgnoreBrowsers("ios,android")
class B85_ZK_3583Test extends ZTL4ScalaTestCase {

  @Test
  def test() = {
    runZTL(() => {
      val popup = jq(".z-popup")

      verifyFalse(popup.exists())

      mouseOver(jq(".z-div").eq(1))
      sleep(1000)
      waitResponse(true)

      verifyTrue(popup.exists())

      mouseOver(jq(".z-button"))
      sleep(1000)
      waitResponse(true)

      verifyEquals("block", popup.css("display"))
    })
  }
}
