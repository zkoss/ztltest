package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-2105.zul")
class B65_ZK_2105Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      click(jq("$startLongOp"))
      waitResponse()
      sleep(5500)
      verifyEquals("Should see true.", "true", jq(".z-label:eq(1)").text())
    })

  }
}