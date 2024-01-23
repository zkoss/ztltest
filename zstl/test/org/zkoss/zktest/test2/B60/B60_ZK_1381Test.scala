package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1381.zul")
class B60_ZK_1381Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(
      () => {
        click(jq(".z-button:contains(Show Busy)"))
        waitResponse()
        verifyEquals("should not be able to edit textbox inside grid", jq(".z-apply-mask").css("display"), "block")
      })
  }
}