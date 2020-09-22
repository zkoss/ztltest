package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1612.zul")
class B65_ZK_1612Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(
      () => {
        val img = jq("img[src*=button]")

        click(img)
        waitResponse()
        verifyTrue("You should see a dialog", jq(".z-messagebox-window").exists())

        click(jq(".z-button"))
        waitResponse()

        val header = jq(".z-panel-header:eq(1)")
        val headerText = header.text()

        val position = "2,2"
        val target = jq(".z-panel-body:eq(1)")
        dragdropToObject(img, target, position, position)
        waitResponse()

        verifyNotEquals("You should see the title of the right side panel is changed.", header.text(), headerText)
      })

  }
}