package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3520.zul")
class F85_ZK_3520Test extends ZTL4ScalaTestCase {
  @Test
  def testBeforeChange()=  {
    runZTL(() => {
      val cyan = jq(".z-div[style*=cyan]")
      val pp = jq("@popup")
      mouseOver(cyan)
      waitResponse()
      sleep(1000)
      // should see tooltip showed at position "before_start"
      verifyTolerant(cyan.offsetTop() + 200, pp.offsetTop(), 1)
      verifyTolerant(cyan.offsetLeft(), pp.offsetLeft(), 1)

      val pink = jq(".z-div[style*=pink]")
      click(pink)
      waitResponse()
      // should see tooltip showed on 20px down of mouse pointer
      verifyTolerant(pink.offsetTop() + 100, pp.offsetTop() - 20, 3)
      verifyTolerant(pink.offsetLeft() + 100, pp.offsetLeft(), 3)

      val yellow = jq(".z-div[style*=yellow]")
      contextMenuAt(yellow, "100,100")
      waitResponse()
      // should see tooltip showed on 50px left of mouse pointer
      verifyTolerant(yellow.offsetTop() + 100, pp.positionTop(), 1)
      verifyTolerant(yellow.offsetLeft() + 100, pp.positionLeft() + 50, 1)
      contextMenuAt(yellow, "100,100")
      waitResponse()
      // should see tooltip showed on 50px left of mouse pointer
      verifyTolerant(yellow.offsetTop() + 100, pp.positionTop(), 1)
      verifyTolerant(yellow.offsetLeft() + 100, pp.positionLeft() + 50, 1)

      //after change
      click(jq("@button"))
      waitResponse()

      mouseMoveAt(cyan, "100,100")
      waitResponse()
      sleep(1000)
      // should see tooltip showed at 40px right of the cursor
      verifyTolerant(cyan.offsetTop() + 100, pp.offsetTop(), 1)
      verifyTolerant(cyan.offsetLeft() + 140, pp.offsetLeft(), 1)

      click(pink)
      waitResponse()
      // should see tooltip showed at the "after_center" position
      verifyTolerant(pink.offsetTop() + 200, pp.offsetTop(), 3)
      verifyTolerant(pink.offsetLeft() + 100, pp.offsetLeft() + pp.width() / 2, 3)

      contextMenuAt(yellow, "50,50")
      waitResponse()
      contextMenuAt(yellow, "25,25")
      waitResponse()
      // should not see tooltip showed
      verifyFalse("yellowPopup should be hidden", pp.isVisible)
    })
  }
}
