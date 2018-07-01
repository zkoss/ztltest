package org.zkoss.zktest.test2.F65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F65-ZK-1655.zul")
class F65_ZK_1655Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      val yellow = jq(".z-div[style*=yellow]")
      contextMenu(yellow)
      waitResponse()
      val yellowPP = jq("@popup")
      // should see tooltip showed on 50px left of mouse pointer
      verifyTolerant(yellowPP.positionTop(), yellow.offsetTop() + 100, 1)
      verifyTolerant(yellowPP.positionLeft() + 50, yellow.offsetLeft() + 100, 1)

      val pink = jq(".z-div[style*=pink]")
      click(pink)
      waitResponse()
      val pinkPP = jq("@popup")

      // should see tooltip showed on 20px down of mouse pointer
      verifyTolerant(pinkPP.offsetTop() - 20, pink.offsetTop() + 100, 3)
      verifyTolerant(pinkPP.offsetLeft(), pink.offsetLeft() + 100, 3)

      val cyan = jq(".z-div[style*=cyan]")
      mouseOver(cyan)
      waitResponse()
      sleep(1000)
      val cyanPP = jq("@popup")

      // should see tooltip showed on 40px right of mouse pointer
      verifyTolerant(cyanPP.offsetTop(), cyan.offsetTop() + 100, 1)
      verifyTolerant(cyanPP.offsetLeft() - 40, cyan.offsetLeft() + 100, 1)
    })
  }
}
