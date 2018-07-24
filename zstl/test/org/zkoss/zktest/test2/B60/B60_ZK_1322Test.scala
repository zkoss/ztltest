package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1322.zul")
class B60_ZK_1322Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
        click(jq("@timebox"))
        waitResponse()
        val timebox = jq(".z-timebox").toWidget().$n("real")
        val time = timebox.attr("value")
        sendKeys(timebox, Keys.HOME)
        sleep(1000)
        waitResponse()
        sendKeys(timebox, "122222")
        sleep(1000)
        waitResponse()
        click(jq("@button"))
        waitResponse()
        verifyEquals(timebox.attr("value"), "")
      })

  }
}
