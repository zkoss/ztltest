package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{SeleniumOnly, Tags}

@SeleniumOnly
class B65_ZK_1617Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val btn = jq(".z-button:contains(Rename)")
        click(btn)
        waitResponse()

        val position = "2,2"
        val src = jq(".z-panel-header")

        val top = src.offsetTop()

        mouseMoveAt(src, position)
        waitResponse()

        mouseDownAt(src, position)
        waitResponse()

        mouseMoveAt(btn, position)
        waitResponse()

        verifyTrue("it should be able to drag and drop.", top != src.offsetTop())

        mouseUpAt(btn, position)
        waitResponse()


      })

  }
}