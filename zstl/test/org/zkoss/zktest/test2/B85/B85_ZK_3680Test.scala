package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B85_ZK_3680Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      verScroll(jq(".z-tabpanel").eq(0), 0.8)
      waitResponse(true)

      click(jq(".z-bandbox-button"))
      waitResponse(true)

      verifyEquals("Did a thing\nopened\n", getZKLog())

      verScroll(jq(".z-tabpanel").eq(0), 0)
      waitResponse(true)

      verifyEquals("Did a thing\nopened\nDid a thing\nclosed\n", getZKLog())
    })
  }
}