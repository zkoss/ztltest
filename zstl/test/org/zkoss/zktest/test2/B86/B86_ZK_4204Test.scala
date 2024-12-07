package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.NonConcurrent

/**
  * @author rudyhuang
  */
@NonConcurrent
class B86_ZK_4204Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      refresh()
      waitForPageToLoad("10000")
      waitResponse()
      verifyNotEquals("rmDesktop not received.","", jq("$rmDesktopIndicator").html())
    })
  }
}
