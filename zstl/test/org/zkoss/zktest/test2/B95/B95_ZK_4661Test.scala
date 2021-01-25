package org.zkoss.zktest.test2.B95

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B95_ZK_4661Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      dragDropAndCheck()
      // do it again
      dragDropAndCheck()
    })
  }

  def dragDropAndCheck(): Unit = {
    val panelHead = jq(".z-panel-head").eq(0)
    dragAndDrop(panelHead, "20,20")
    waitResponse()

    verifyEquals("panel should not move", "", getZKLog())
    closeZKLog()
  }

}