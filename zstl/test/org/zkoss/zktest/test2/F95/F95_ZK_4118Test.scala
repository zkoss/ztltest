package org.zkoss.zktest.test2.F95

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

@IgnoreBrowsers("chrome,ff,safari,ie11,ie10,ie9,edge")
class F95_ZK_4118Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      waitResponse()
      val log = getZKLog()
      verifyNotContains(log, "zk.edge: false")
      verifyContains(log, "zk.edge_legacy: false")
      val resultLabel = jq("$result").html()
      verifyNotContains(resultLabel.trim(), "edge: , edge_legacy:")
      verifyNotContains(resultLabel.trim(), "edge_legacy: ")
    })
  }
}