package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers
import org.zkoss.ztl.unit.JQuery

/**
  * @author leonlee
  */
@IgnoreBrowsers("chrome,safari,edge,ie11,ie10,ie9")
class B50_ZK_580Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val textbox: JQuery = jq(".z-textbox")
      clickAt(textbox, "70,5")
      waitResponse()
      val originCursorPosition: String = zk(textbox).eval("getSelectionRange()[0]")
      mouseMove(jq(".z-label"))
      waitResponse()
      clickAt(textbox, "100,5")
      waitResponse()
      verifyNotEquals(originCursorPosition, zk(textbox).eval("getSelectionRange()[0]"))
    })
  }
}
