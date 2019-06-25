package org.zkoss.zktest.test2.B50

import java.util

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers
import org.zkoss.ztl.unit.JQuery

/**
  * @author leonlee
  */
@IgnoreBrowsers("ff,edge")
class B50_ZK_338Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val timeboxInput: JQuery = jq(".z-timebox-input")
      click(jq(".z-timebox-up"))
      waitResponse()
      click(jq("@label"))
      waitResponse()
      val origin: String = jq(".z-timebox").toWidget().$n("real").attr("value");

      doubleClickAt(timeboxInput, "3,3")
      waitResponse()

      for (i <- 0 to 2) {
        sendKeys(timeboxInput ,Keys.ARROW_RIGHT)
        waitResponse()
      }
      sendKeys(timeboxInput ,Keys.ARROW_UP)
      waitResponse()
      sendKeys(timeboxInput ,Keys.ARROW_DOWN)
      waitResponse()
      sendKeys(timeboxInput ,Keys.ARROW_DOWN)
      waitResponse()
      blur(timeboxInput)
      waitResponse()
      verifyEquals(origin.substring(0, 1), jq(".z-timebox").toWidget().$n("real").attr("value").substring(0, 1))
    })
  }
}
