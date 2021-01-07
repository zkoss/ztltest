package org.zkoss.zktest.test2.B90

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

@Tags(tags = "B90-ZK-4407.zul")
@IgnoreBrowsers("ff,edge_legacy,ie11,ie10,ie9")
class B90_ZK_4407Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit =  {
    runZTL(() => {
      evalScript("window.scroll(0, 0)")
      refresh()
      waitResponse()
      verifyNotEquals(0, jq("html").scrollTop())
      sleep(1000)
      click(jq("@button"))
      waitResponse()
      verifyEquals("history.scrollRestoration: auto", getZKLog())
    })
  }
}
