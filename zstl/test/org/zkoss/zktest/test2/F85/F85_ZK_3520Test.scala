package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.zkoss.ztl.util.Scripts

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3520.zul")
class F85_ZK_3520Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val cyan = jq(".z-div[style*=cyan]")
      val pp = jq("@popup")
      Scripts.triggerMouseEventAt(driver(), cyan, "mouseover", "100,100")
      waitResponse()
      sleep(1000)
      // should see tooltip showed at position "before_start"
      verifyTolerant(pp.offsetTop(), cyan.offsetTop() + 200, 1)
      verifyTolerant(pp.offsetLeft(), cyan.offsetLeft(), 1)

      val pink = jq(".z-div[style*=pink]")
      getActions
        .moveToElement(findElement(pink))
        .click()
        .perform()
      waitResponse()
      // should see tooltip showed on 20px down of mouse pointer
      verifyTolerant(pp.offsetTop() - 20, pink.offsetTop() + 100, 3)
      verifyTolerant(pp.offsetLeft(), pink.offsetLeft() + 100, 3)

      val yellow = jq(".z-div[style*=yellow]")
      getActions
        .moveToElement(findElement(yellow))
        .contextClick()
        .perform()
      waitResponse()
      // should see tooltip showed on 50px left of mouse pointer
      verifyTolerant(pp.positionTop(), yellow.offsetTop() + 100, 1)
      verifyTolerant(pp.positionLeft() + 50, yellow.offsetLeft() + 100, 1)

      click(jq("@button"))
      waitResponse()

      getActions
        .moveToElement(findElement(yellow))
        .contextClick()
        .moveByOffset(0, -10)
        .contextClick()
        .perform()
      waitResponse()
      // should not see tooltip showed
      verifyFalse("yellowPopup should be hidden", pp.isVisible)

      Scripts.triggerMouseEventAt(driver(), cyan, "mouseover", "100,100")
      waitResponse()
      sleep(1000)
      // should see tooltip showed at 40px right of the cursor
      verifyTolerant(pp.offsetTop(), cyan.offsetTop() + 100, 1)
      verifyTolerant(pp.offsetLeft(), cyan.offsetLeft() + 140, 1)

      getActions
        .moveToElement(findElement(pink))
        .click()
        .perform()
      waitResponse()
      // should see tooltip showed at the "after_center" position
      verifyTolerant(pp.offsetTop(), pink.offsetTop() + 200, 3)
      verifyTolerant(pp.offsetLeft() + pp.width() / 2, pink.offsetLeft() + 100, 3)
    })
  }
}
