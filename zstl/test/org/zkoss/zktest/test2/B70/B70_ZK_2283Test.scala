package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2283.zul")
class B70_ZK_2283Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        click(jq(".z-combobox-input"))
        sendKeys(jq(".z-combobox-input"), "a")
        sleep(500)
        sendKeys(jq(".z-combobox-input"), "b")
        sleep(500)
        sendKeys(jq(".z-combobox-input"), Keys.BACK_SPACE)
        sleep(500)
        sendKeys(jq(".z-combobox-input"), "a")
        sleep(500)
        waitResponse()
        sleep(1000)
        val suggestion = jq(".z-comboitem-selected .z-comboitem-text").eq(0).html()
        verifyContains("Suggestion fail. Can't match the typing.", suggestion, "aba")
      })

  }
}