package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1452.zul")
class B65_ZK_1452Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
      var col = jq("$col")
      click(col)
      waitResponse()
      click(col)
      waitResponse()
      click(col)
      waitResponse()
      verifyTrue("Should not see js error message", !jq(".z-errorbox").exists())
    })
  }
}
