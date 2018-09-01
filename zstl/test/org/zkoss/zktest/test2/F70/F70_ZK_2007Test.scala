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
      verifyEquals("open the popup", true, jq(".z-popup").exists)

      contextMenuAt(item, "0,0")
      waitResponse()
      verifyEquals("it will close", false, jq(".z-popup").isVisible())

      click(item1)
      waitResponse()
      verifyEquals("open the context menu", true, jq(".z-menupopup").exists)
      clickAt(item1, "1,1")
      waitResponse()
      verifyEquals("it will close", false, jq(".z-menupopup").isVisible())

      contextMenu(item2)
      waitResponse()
      verifyEquals("open the context menu", true, jq(".z-menupopup").exists)

      contextMenuAt(item2, "1,1")
      waitResponse()
      verifyEquals("it will close", false, jq(".z-menupopup").isVisible())
    })

  }
}
