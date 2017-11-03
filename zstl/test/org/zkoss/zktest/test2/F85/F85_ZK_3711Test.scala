package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{IgnoreBrowsers, Tags}

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3711.zul")
@IgnoreBrowsers("ie9")
class F85_ZK_3711Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val btns = jq("@button")
      click(btns.eq(1)) // push page 2
      waitResponse()
      click(btns.eq(3)) // push page 4
      waitResponse()
      click(btns.eq(7)) // replace page 3
      waitResponse()

      val tabbox = jq("@tabbox").toWidget
      driver().navigate().back()
      waitResponse()
      verifyEquals(tabbox.get("selectedIndex"), 1) // page 2

      driver().navigate().forward()
      waitResponse()
      verifyEquals(tabbox.get("selectedIndex"), 2) // page 3
    })
  }
}
