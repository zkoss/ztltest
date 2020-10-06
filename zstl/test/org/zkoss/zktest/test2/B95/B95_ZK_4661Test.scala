package org.zkoss.zktest.test2.B95

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B95_ZK_4661Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      mouseActionAndCheck()
      // do it again
      mouseActionAndCheck()
    })
  }

  def mouseActionAndCheck(): Unit = {
    val panel3Top = jq(".z-panel").eq(2).positionTop()
    mouseDownAt(jq(".z-panel-head"), "5,5")
    waitResponse()

    mouseMoveAt(jq(".z-panel").eq(1), "10,10")
    waitResponse()

    verifyEquals("panel3 should not move during dragging", panel3Top, jq(".z-panel").eq(2).positionTop())

    mouseUpAt(jq(".z-portallayout"), "5,5")
    waitResponse()
  }
}