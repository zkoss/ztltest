package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1003.zul")
class B60_ZK_1003Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      verifyEquals("should see two Toolbar below the 'Panel Content'", jq(".z-panel .z-toolbar-panel").length(), 2)
    })
  }
}