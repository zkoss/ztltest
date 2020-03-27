
package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1454.zul")
class B65_ZK_1454Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
      click(jq(".z-treerow:contains(1):eq(0)").toWidget().$n("icon"))
      waitResponse()
      click(jq(".z-treerow:contains(3):eq(0)").toWidget().$n("icon"))
      waitResponse()
      click(jq(".z-treerow:contains(7):eq(0)").toWidget().$n("icon"))
      waitResponse()
      click(jq(".z-treerow:contains(15):eq(0)").toWidget().$n("icon"))
      waitResponse()
      click(jq(".z-treerow:contains(31):eq(0)").toWidget().$n("icon"))
      waitResponse()
      click(jq(".z-treerow:contains(63):eq(0)").toWidget().$n("icon"))
      waitResponse()
      click(jq(".z-treerow:contains(127):eq(0)").toWidget().$n("icon"))
      waitResponse()
      click(jq(".z-treerow:contains(255):eq(0)").toWidget().$n("icon"))
      waitResponse()

      jq(".z-tabpanel").toElement().set("scrollTop", 28)
      click(jq(".z-tab:contains(2)"))
      waitResponse()
      click(jq(".z-tab:contains(1)"))
      waitResponse()
      verifyEquals("The scrollbar should be at the previous position", jq(".z-tabpanel").scrollTop(), 28)
    })

  }
}