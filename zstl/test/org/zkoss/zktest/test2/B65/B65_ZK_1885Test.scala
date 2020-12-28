package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * @author rudyhuang
  */
class B65_ZK_1885Test extends ZTL4ScalaTestCase {
  @Test
  def test() {
    runZTL(() => {
      val div = jq("@div")
      verScrollAbs(div, 100)
      waitResponse()
      windowResizeTo(640, 480)
      waitResponse()

      verifyNotEquals(0, div.scrollTop)
    })
  }
}
