package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1142.zul")
class B60_ZK_1142Test extends ZTL4ScalaTestCase {
  @Test
  def testClick(): Unit = {
    runZTL(
      () => {
        val newMenu = jq(".z-menu:contains(New)")
        val strs = List("Document", "Spreadsheet", "Presentation")
        for (str <- strs) {
          click(jq("@menu:contains(File)"))
          waitResponse()
          click(newMenu)
          waitResponse()
          mouseOver(newMenu)
          waitResponse()
          click(jq("@menuitem:contains(" + str + ")"))
          waitResponse()
          verifyEquals("should see alert message displayed", jq(".z-messagebox-window @label").text(), str)
          click(jq("@button"))
          waitResponse()
        }
      })
  }
}
