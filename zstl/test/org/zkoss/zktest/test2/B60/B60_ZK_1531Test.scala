package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1531.zul")
class B60_ZK_1531Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<?page title="new page title" contentType="text/html;charset=UTF-8"?>
      <zk>
        <window id="win1" title="new page title" border="normal">
          Right click on the button, should only see "Right clicked" message showed.<separator/>
          <button image="/img/inet.png" onClick='lbl.value="Left Clicked"' onRightClick='lbl.value="Right Clicked"'></button>
          <label id="lbl" style="color: red"/>
        </window>
      </zk>"""

    runZTL(zscript,
      () => {
        contextMenu(jq(".z-button"))
        waitResponse()
        verifyTrue("should only see 'Right clicked' message showed.", jq(".z-label:contains(Right Clicked)").exists())
        verifyTrue("should only see 'Right clicked' message showed.", !jq(".z-label:contains(Left Clicked)").exists())
      })

  }
}
