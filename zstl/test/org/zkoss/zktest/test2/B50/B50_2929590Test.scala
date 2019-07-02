package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author rudyhuang
  */
class B50_2929590Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()

      val modalWin = jq("$win")
      val offsetLeft = modalWin.offsetLeft()
      val offsetTop = modalWin.offsetTop()

      dragAndDrop(modalWin.find(".z-window-header-move"), "50,50")
      waitResponse()

      verifyNotEquals(offsetLeft, modalWin.offsetLeft())
      verifyNotEquals(offsetTop, modalWin.offsetTop())
    })
  }
}
