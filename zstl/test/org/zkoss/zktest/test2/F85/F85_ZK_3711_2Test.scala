package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{IgnoreBrowsers, Tags}

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3711-2.zul")
@IgnoreBrowsers("ie9")
class F85_ZK_3711_2Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val btns = jq("@button")
      click(btns.eq(0)) // push 1
      waitResponse()
      click(btns.eq(0)) // push 2
      waitResponse()
      click(btns.eq(1)) // replace 3
      waitResponse()

      driver().navigate().back()
      waitResponse()
      verifyContains("It should be f1=1.", getZKLog, "{\"f1\":1,")

      driver().navigate().forward()
      waitResponse()
      verifyContains("It should be f1=3.", getZKLog, "{\"f1\":3,")
    })
  }
}
