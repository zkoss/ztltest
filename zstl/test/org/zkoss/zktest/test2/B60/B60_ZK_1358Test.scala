package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1358.zul")
class B60_ZK_1358Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk xmlns:h="native">
                    <label multiline="true" style="font-size: 14px">
                      1. If not see Modal Window, it is a bug.
	2. Click 'popup' button, should see Popup.
                    </label>
                    <window vflex="1" hflex="1" border="none" position="center" mode="modal">
                      <div style="background-color:gold;" width="437px" height="341px">
                        Modal Window
                        <button id="btn" label="popup" onClick='pp.open(self, "after_end");'/>
                        <popup vflex="1" hflex="1" id="pp">
                          <div style="background-color: pink;" width="200px" height="100px">Popup</div>
                        </popup>
                      </div>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyEquals(jq(".z-window-modal").css("display"), "block")

        click(jq("@button"))
        waitResponse()
        verifyEquals(jq(".z-popup").css("visibility"), "visible")
      })

  }
}
