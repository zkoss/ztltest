package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1609.zul")
class B65_ZK_1609Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(
      () => {
        click(jq(".z-button:contains(close)"))
        waitResponse()
        click(jq(".z-treerow").toWidget().$n("icon"))
        waitResponse()
        verifyTrue("should see the Node2 is closed, and with a close icon", jq(jq(".z-treerow:contains(Node 2)").toWidget().$n("icon")).hasClass("z-tree-close"))
      })

  }
}
