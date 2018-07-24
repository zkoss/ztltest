package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F70-ZK-2007.zul")
class F70_ZK_2007Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      val item = jq(".z-treerow:contains(Item)")
      val item1 = jq(".z-treerow:contains(Item1)")
      val item2 = jq(".z-treerow:contains(Item2)")
      contextMenu(item)
      waitResponse()
      verifyTrue("open the popup", jq(".z-popup").exists)

      contextMenuAt(item, "0,0")
      waitResponse()
      verifyTrue("it will close", !jq(".z-popup").isVisible())

      click(item1)
      waitResponse()
      verifyTrue("open the context menu", jq(".z-menupopup").exists)
      clickAt(item1, "1,1")
      waitResponse()
      verifyTrue("it will close", !jq(".z-menupopup").isVisible())

      contextMenu(item2)
      waitResponse()
      verifyTrue("open the context menu", jq(".z-menupopup").exists)

      contextMenuAt(item2, "1,1")
      waitResponse()
      verifyTrue("it will close", !jq(".z-menupopup").isVisible())
    })

  }
}
