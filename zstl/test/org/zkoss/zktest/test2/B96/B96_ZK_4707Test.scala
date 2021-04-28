package org.zkoss.zktest.test2.B96

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

@IgnoreBrowsers("chrome,safari,edge_legacy,edge,ie11,ie10,ie9")
class B96_ZK_4707Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      waitResponse()
      click(jq("$tb"))
      waitResponse()
      click(jq("$item"))
      waitResponse()
      verifyTrue("2nd popup should be visible", jq(".z-menupopup").isVisible)
    })
  }
}
