package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

// TestCafe android's mouseDown will trigger touchStart as well (2 events triggered), the test will fail, move android test case to zats worked well
@IgnoreBrowsers("android")
class B36_2973306Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      var detail = jq("$detail").toWidget
      click(detail.$n("icon"))
      waitResponse()
      verifyEquals(1, jq(detail.$n("fake")).find(">td").length())
    })
  }

}
