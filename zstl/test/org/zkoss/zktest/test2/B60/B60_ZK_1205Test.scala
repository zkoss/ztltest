package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1205.zul")
class B60_ZK_1205Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(
      () => {
        click(jq(".z-button:contains(click me)"))
        waitResponse()
        verifyTrue("should exist", jq(".z-notification").exists())
        verifyNotEquals("displays a notification message", jq(".z-notification").css("visibility"), "hidden")

        sleep(2000)
        verifyTrue("The message should not disappear immediately after it opened. Otherwise, it is an error.", jq(".z-notification").exists())

        click(jq(".z-panel"))
        waitResponse()
        sleep(2000)
        verifyTrue("The message should only close upon mouse click.", !jq(".z-notification").exists())
      })

  }
}
