package org.zkoss.zktest.test2.B95

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

@IgnoreBrowsers("chrome,safari,ie11,ie10,ie9,edge-chromium")
class B95_ZK_4665Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      waitResponse()
      verifyEquals(jq("$cMid").offsetTop(), (jq("$cRig").offsetTop()))
    })
  }
}