package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1309.zul")
class B65_ZK_1309Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(
      () => {
        click(jq("@button:contains(Open)"))
        waitResponse()

        verifyTrue("should show modal window", jq(".z-window-modal").isVisible())

        val btn = jq(".z-button:contains(click)")
        click(btn)
        waitResponse()

        verifyTrue("should show notification", jq(".z-notification").isVisible())

        val dragHandle = jq(".z-window-header-move")
        dragdropTo(dragHandle, "2,2", "52,2")
        waitResponse()
        verifyTrue("the mask of modal window can't disappear", jq(".z-modal-mask").isVisible())
        verifyFalse("should hide notification", jq(".z-notification").isVisible())
      })

  }
}