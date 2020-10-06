package org.zkoss.zktest.test2.B95

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

@IgnoreBrowsers("chrome,ff,safari,ie11")
class B95_ZK_4588Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        val input = jq(".z-combobox-input")
        click(input)
        sendKeys(input, "a")
        sleep(500)
        sendKeys(input, "b")
        sleep(500)
        sendKeys(input, Keys.BACK_SPACE)
        sleep(500)
        sendKeys(input, "a")
        sleep(500)
        waitResponse()
        sleep(1000)

        verifyEquals("abacus", input.`val`())
        verifyEquals("3", input.get(0).attr("selectionStart"))
        verifyEquals("6", input.get(0).attr("selectionEnd"))
      })

  }
}