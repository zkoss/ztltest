package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-2660.zul")
class B80_ZK_2660Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val header = jq(".z-listheader").last()
        val btn = jq(".z-listheader").last().find("a")
        mouseOver(header)
        waitResponse()
        click(btn)
        waitResponse()
        click(jq(".z-menuitem-checked").first().find("a"))
        waitResponse()
        click(jq(".z-button"))
        waitResponse()
        verifyEquals("Column: Id, Visible:falseColumn: Code, Visible:trueColumn: Name, Visible:true",
          jq(".z-notification-content").text())
      })

  }
}
