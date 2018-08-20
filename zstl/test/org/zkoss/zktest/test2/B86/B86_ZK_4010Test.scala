package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.JQuery

/**
  * @author rudyhuang
  */
@Tags(tags = "B86-ZK-4010.zul")
class B86_ZK_4010Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit =  {
    runZTL(() => {
      // The width of column 1, 4, 6 and Aux 3 should be nearly 0
      verifyTolerant(0, getWidth(jq("@listcell:eq(0)")), 1)
      verifyTolerant(0, getWidth(jq("@listcell:eq(3)")), 1)
      verifyTolerant(0, getWidth(jq("@listcell:eq(5)")), 1)
      verifyTolerant(0, getWidth(jq("@auxheader:eq(2)")), 1)

      click(jq("@button:contains(switch 1 visible)"))
      waitResponse()
      verifyTrue(getWidth(jq("@listcell:eq(0)")) > 1)

      click(jq("@button:contains(switch 6 visible)"))
      waitResponse()
      verifyTrue(getWidth(jq("@listcell:eq(5)")) > 1)
      verifyTrue(getWidth(jq("@auxheader:eq(2)")) > 1)
    })
  }

  private def getWidth(elem: JQuery): Int = {
    // Use clientWidth instead of width() to avoid negative bug https://stackoverflow.com/q/22832719
    elem.toElement.attr("clientWidth").toInt
  }
}
