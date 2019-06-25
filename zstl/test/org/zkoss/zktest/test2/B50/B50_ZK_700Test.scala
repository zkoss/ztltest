package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

/**
  * @author leonlee
  */
@IgnoreBrowsers("chrome,ff,safari,edge,ie11,ie10")
class B50_ZK_700Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("$div"))
      waitResponse()
      click(jq(".z-button").eq(0))
      waitResponse()
      verifyEquals("100 + 100 + 100 = 300\n100 + 100 + 100 = 300", getZKLog())
    })
  }
}
