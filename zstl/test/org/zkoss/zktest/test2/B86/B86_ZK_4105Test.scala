package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author rudyhuang
  */
class B86_ZK_4105Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val comboInput = jq("@combobox input")
      sendKeys(comboInput, "-abc")
      sendKeys(comboInput, Keys.TAB)
      waitResponse()
      verifyEquals("(empty)", getZKLog)
      closeZKLog()

      focus(comboInput)
      sendKeys(comboInput, Keys.LEFT)
      sendKeys(comboInput, Keys.LEFT)
      sendKeys(comboInput, Keys.LEFT)
      sendKeys(comboInput, Keys.LEFT)
      waitResponse()
      sendKeys(comboInput, Keys.DELETE)
      sendKeys(comboInput, Keys.TAB)
      waitResponse()
      verifyNotEquals("(empty)", getZKLog)
    })
  }
}
