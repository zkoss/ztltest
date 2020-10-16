package org.zkoss.zktest.test2.F95

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

@IgnoreBrowsers("chrome,ff,safari,ie11,ie10,ie9,edge_chromium")
class F95_ZK_4118_1Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      waitResponse()
      val log = getZKLog()
      verifyContains(log, "zk.edge: false")
      verifyNotContains(log, "zk.edge_legacy: false")
      val resultLabel = jq("$result").html()
      verifyContains(resultLabel.trim(), "edge: , edge_legacy:")
      verifyContains(resultLabel.trim(), "edge_legacy: ")
    })
  }
}