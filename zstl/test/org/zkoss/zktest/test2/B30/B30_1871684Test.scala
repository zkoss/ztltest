package org.zkoss.zktest.test2.B30

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B30-1871684.zul,Tree")
class B30_1871684Test extends ZTL4ScalaTestCase {
  def test(): Unit = {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq("@treerow").isVisible)

      click(jq("@button"))
      waitResponse()
      verifyTrue(jq("@treerow").isVisible)
    })
  }
}
