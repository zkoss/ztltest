/* B30_1455584Test.java

        Purpose:

        Description:

        History:
                Mon Apr 14 14:12:12 CST 2025, Created by jamson

Copyright (C) 2025 Potix Corporation. All Rights Reserved.
*/

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.openqa.selenium.Keys

@Tags(tags = "Touch,Android")
class B102_ZK_4861Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
      var timeboxInput = jq(".z-timebox-input")
      var label = jq("$lb")
      click(timeboxInput)
      waitResponse()

      val backSpaceStr = Keys.BACK_SPACE.toString
      var backSpaces = backSpaceStr + backSpaceStr + backSpaceStr + backSpaceStr + backSpaceStr + backSpaceStr
      var keys = backSpaces + "foobar"
      sendKeys(timeboxInput.toWidget(), keys)
      waitResponse()

      blur(timeboxInput)
      waitResponse()

      verifyEquals("", timeboxInput.get(0).attr("value"))
      verifyTrue(label.text() == "")

      var keys2 = backSpaces + "05:16"
      sendKeys(timeboxInput.toWidget(), keys2)
      waitResponse()

      blur(timeboxInput)
      waitResponse()

      verifyEquals("05:16", timeboxInput.get(0).attr("value"))
      verifyTrue(label.text() != "")


    })
  }
}