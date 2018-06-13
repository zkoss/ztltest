package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3943.zul")
class B85_ZK_3943Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("@button:eq(0)"))
      waitResponse()
      checkPopupPosition(jq("@button:eq(0)"), jq("$mypop"))

      click(jq("@button:eq(1)"))
      waitResponse()
      checkPopupPosition(jq("@button:eq(1)"), jq("$mypop"))

      windowResizeTo(1000, 800)
      checkPopupPosition(jq("@button:eq(1)"), jq("$mypop"))
    })
  }

  def checkPopupPosition(btn: JQuery, pp: JQuery): Unit = {
    val popRightEdge = pp.offsetLeft() + pp.outerWidth()
    val btnRightEdge = btn.offsetLeft() + btn.outerWidth()
    verifyTolerant(popRightEdge, btnRightEdge, 2)
  }
}
