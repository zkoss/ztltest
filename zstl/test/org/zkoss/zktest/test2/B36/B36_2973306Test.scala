package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

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
