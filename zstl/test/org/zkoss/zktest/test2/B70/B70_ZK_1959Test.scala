package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-1959.zul")
class B70_ZK_1959Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      var h =  jq(jq(".z-tabbox").toWidget().$n("left")).height()
      click(jq(".z-button"))
      waitResponse()
      verifyEquals("the height of arrow should not change", h, jq(jq(".z-tabbox").toWidget().$n("left")).height())
    })
  }
}