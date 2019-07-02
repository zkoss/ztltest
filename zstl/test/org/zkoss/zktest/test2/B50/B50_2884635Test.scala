package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.SeleniumOnly

/**
  * @author rudyhuang
  */
@SeleniumOnly
class B50_2884635Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq(".z-datebox-button"))
      waitResponse()

      val input = jq(".z-timebox-input")
      click(input)
      waitResponse()

      evalScript(zk(input) + ".setSelectionRange(0,0)")
      getActions.clickAndHold(findElement(jq(".z-timebox-down"))).perform()
      verifyEquals("0", input.get(0).attr("selectionStart"))
      verifyEquals("2", input.get(0).attr("selectionEnd"))
      getActions.release().perform()
    })
  }
}
