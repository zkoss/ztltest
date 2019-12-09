package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1473.zul")
class B65_ZK_1473Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val opt = jq(".z-listitem:contains(Option 0)")
        click(opt)
        waitResponse()

        val a = widget("@listbox").$n("a")
        sendKeys(a, Keys.PAGE_DOWN)
        sleep(200)
        sendKeys(a, Keys.PAGE_DOWN)
        sleep(200)
        sendKeys(a, Keys.PAGE_DOWN)
        sleep(200)
        sendKeys(a, Keys.PAGE_DOWN)
        sleep(200)
        sendKeys(a, Keys.PAGE_DOWN)
        sleep(200)
        sendKeys(a, Keys.PAGE_DOWN)
        sleep(200)
        sendKeys(a, Keys.PAGE_DOWN)
        sleep(200)
        sendKeys(a, Keys.PAGE_DOWN)
        sleep(200)
        sendKeys(a, Keys.PAGE_DOWN)
        sleep(200)
        sendKeys(a, Keys.PAGE_DOWN)
        waitResponse()

        val seld = jq(".z-listitem-selected")
        verifyNotEquals("should not see it jump back to top.", seld.html(), opt.html())
      })

  }
}
