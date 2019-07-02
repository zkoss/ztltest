package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author rudyhuang
  */
class B50_1952402Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()

      val iframe = jq("@window @iframe")
      evalScript(iframe + ".contents().find(\".z-button\").click()")
      waitResponse()
      val textboxVal = iframe.eval("contents().find(\".z-textbox\").val()")
      verifyEquals("1", textboxVal)
    })
  }
}
