package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3711.zul")
@IgnoreBrowsers("ie9")
class F85_ZK_3711Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      val btns = jq("@button")
      click(btns.eq(1)) // push page 2
      waitResponse()
      click(btns.eq(3)) // push page 4
      waitResponse()
      click(btns.eq(7)) // replace page 3
      waitResponse()

      val tabbox = jq("@tabbox").toWidget
      navigatePage(false)
      waitResponse()
      verifyEquals(tabbox.attr("selectedIndex"), 1) // page 2
      navigatePage(true)
      waitResponse()
      verifyEquals(tabbox.attr("selectedIndex"), 2) // page 3
    })
  }
}
