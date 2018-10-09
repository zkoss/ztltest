package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags
import org.zkoss.ztl.unit.JQuery

/**
  * @author rudyhuang
  */
@Tags(tags = "B86-ZK-4011.zul")
class B86_ZK_4011Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit =  {
    runZTL(() => {
      // The width of column 1, 4, 6 and Aux 3 should be nearly 0
      verifyTolerant(0, jq("@cell:eq(0)").toElement.attr("clientWidth"), 1)
      verifyTolerant(0, jq("@cell:eq(3)").toElement.attr("clientWidth"), 1)
      verifyTolerant(0, jq("@cell:eq(5)").toElement.attr("clientWidth"), 1)
      verifyTolerant(0, jq("@auxheader:eq(2)").toElement.attr("clientWidth"), 1)

      click(jq("@button:contains(switch 1 visible)"))
      waitResponse()
      verifyTrue(parseInt(jq("@cell:eq(0)").toElement.attr("clientWidth")) > 1)

      click(jq("@button:contains(switch 6 visible)"))
      waitResponse()
      verifyTrue(parseInt(jq("@cell:eq(5)").toElement.attr("clientWidth")) > 1)
      verifyTrue(parseInt(jq("@auxheader:eq(2)").toElement.attr("clientWidth")) > 1)
    })
  }
}
