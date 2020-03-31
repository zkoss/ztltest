package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author rudyhuang
  */
class B70_ZK_2795Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("@a"))
      waitResponse()

      click(jq("@popup"))
      waitResponse()

      clickAt(jq("@textbox"), "5,5")
      sendKeys(jq("@textbox"), "12")
      waitResponse()

      click(jq("@button"))
      waitResponse()

      verifyNotEquals("3. focus here and change value", jq("$testLabel").text())
    })
  }
}
