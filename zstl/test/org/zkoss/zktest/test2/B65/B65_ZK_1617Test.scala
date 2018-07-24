package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{SeleniumOnly, Tags}

class B65_ZK_1617Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val btn = jq(".z-button:contains(Rename)")
        click(btn)
        waitResponse()
        val src = jq(".z-panel-header")
        dragAndDrop(src, "100,100")
        waitResponse()
        verifyNotEquals("it should be able to drag and drop.", jq("$pos").text(), src.offsetTop())

      })

  }
}