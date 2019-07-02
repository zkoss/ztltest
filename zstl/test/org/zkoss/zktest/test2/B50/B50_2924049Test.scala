package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.SeleniumOnly

/**
  * @author rudyhuang
  */
@SeleniumOnly
class B50_2924049Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val width = jq("@div:first").width()
      val dragPoint = -width / 2 + 10 // W3C uses center as initial point

      getActions.moveToElement(findElement(jq("@div:first")), dragPoint, dragPoint)
        .clickAndHold()
        .moveByOffset(50, 50)
        .perform()
      verifyEquals(1, jq("#zk_ddghost").children().length())
      getActions
        .release()
        .perform()

      getActions.moveToElement(findElement(jq("@div:last")), dragPoint, dragPoint)
        .clickAndHold()
        .moveByOffset(50, 50)
        .perform()
      verifyEquals(0, jq("#zk_ddghost").children().length())
      getActions
        .release()
        .perform()
    })
  }
}
