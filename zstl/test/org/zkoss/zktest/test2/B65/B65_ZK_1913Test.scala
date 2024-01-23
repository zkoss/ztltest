package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1913.zul")
class B65_ZK_1913Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(
      () => {
        click(jq(".z-button"))
        waitResponse()
        verifyTrue("it will show true.", jq(".z-label:contains(true)").length() == 2)
      })
  }
}