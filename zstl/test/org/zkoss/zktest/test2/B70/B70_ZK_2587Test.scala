package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2587.zul")
class B70_ZK_2587Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val label = jq(".z-tabpanel .z-label")
        val tab = jq(".z-tab")
        dragAndDropToObject(label, tab)
        waitResponse(true)
        verifyEquals("dropped: 'in tabbox'", jq(".z-tab .z-tab-text").text())
      })

  }
}