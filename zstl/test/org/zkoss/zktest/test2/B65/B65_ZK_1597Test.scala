package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1597.zul")
class B65_ZK_1597Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(
      () => {
        val position = "2,2"
        val src = jq(".z-tab:contains(Items)")
        val target = jq(".z-tab:contains(tab 1)")
        dragdropToObject(src, target, position, position)
        waitResponse()
        verifyEquals("The tab 'Items' should be selected and the content displays the first tabpanel.", "Items", jq(".z-tab:eq(0)").text())
        verifyTrue("The tab 'Items' should be selected and the content displays the first tabpanel.", jq(".z-tabpanel:eq(0) .z-label:contains(1)").exists())
      })

  }
}
