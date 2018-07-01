package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3683.zul")
class F85_ZK_3683Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val splitter = jq("@splitlayout .z-splitlayout-splitter")
      val win = jq("@window")
      val win1H = win.eq(1).height()
      val win2H = win.eq(2).height()

      dragdropTo(splitter, "0, 0", "0, -50")
      waitResponse()
      verifyTolerant(win1H - 50, win.eq(1).height(), 2)
      verifyTolerant(win2H + 50, win.eq(2).height(), 2)

      click(splitter.find(".z-splitlayout-splitter-button"))
      waitResponse()
      verifyFalse("Window 1 should be hidden", win.eq(1).isVisible)

      click(splitter.find(".z-splitlayout-splitter-button"))
      waitResponse()
      verifyTrue("Window 1 should be visible", win.eq(1).isVisible)

      click(jq("@button"))
      waitResponse()
      verifyEquals("There are 4 windows now. (including outer window)", win.length(), 4)
    })
  }
}
