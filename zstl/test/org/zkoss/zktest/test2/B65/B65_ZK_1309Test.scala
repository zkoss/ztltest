package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.util.Scripts
import org.zkoss.ztl.ZK
import org.zkoss.ztl.JQuery

@Tags(tags = "B65-ZK-1309.zul")
class B65_ZK_1309Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk>
                    <label multiline="true">
                      1. Click "Open modal window" button, it will show modal window
	2. Click "click me" button in modal window, it will show notification
	3.1 Click anywhere beside modal winow's title, notification will disapper and then drag modal window
	or
	3.2 Drag modal window directly
	4. Both 3.1 and 3.2, the mask of modal winodw can't dispear.
                    </label>
                    <button label="Open modal window">
                      <attribute name="onClick">
                        modalWindow.setVisible(true)
                      </attribute>
                    </button>
                    <window id="modalWindow" mode="modal" title="Modal window" visible="false" width="80%" height="50%" border="normal">
                      <button label="click me">
                        <attribute name="onClick">
                          Clients.showNotification("Now try to drag around the modal window")
                        </attribute>
                      </button>
                    </window>
                  </zk>

    runZTL(zscript,
      () => {
        click(jq("@button:contains(Open)"))
        waitResponse()

        verifyTrue("should show modal window", jq(".z-window-modal").isVisible())

        val btn = jq(".z-button-cm:contains(click)")
        click(btn)
        waitResponse()

        verifyTrue("should show notification", jq(".z-notification").isVisible())

        val window = jq(".z-window-modal-header")

        dragdropTo(window, window.outerWidth() + ",0",
          (window.outerWidth() + 50) + ",0")

        verifyTrue("the mask of modal winodw can't dispear", jq(".z-modal-mask").isVisible())

      })

  }
}