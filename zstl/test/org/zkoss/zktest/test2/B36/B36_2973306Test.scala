package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

class B36_2973306Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      var detail = jq("$detail").toWidget
      if(!isSafari)
        click(detail.$n("icon"))
      else
        clickAt(detail.$n("icon"), "2,2")
      waitResponse()
      verifyEquals(1, jq(detail.$n("fake")).find(">td").length())
    })
  }
     
}
