package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-1683.zul")
class B70_ZK_1683Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      verifyTrue("You should not see an endless loop for the alert message.", jq(".z-window-modal").length() == 1)
      click(jq(".z-window-close"))
      waitResponse()
      verifyTrue("You should not see an endless loop for the alert message.", jq(".z-window-modal").length() == 1)
    })
  }
}