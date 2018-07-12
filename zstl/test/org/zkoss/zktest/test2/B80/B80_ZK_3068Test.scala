package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase

class B80_ZK_3068Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        // A workaround for losing focus when page loaded
        refresh()
        waitForPageToLoad("5000")

        val btn1 = jq("$btn1")
        val zcf = "zk.currentFocus.uuid"
        verifyEquals(getEval(zcf), btn1.get(0).attr("id"))
        sendKeys(btn1, Keys.TAB)
        waitResponse()
        verifyEquals(getEval(zcf), jq("$btn2").get(0).attr("id"))
      })
  }
}

