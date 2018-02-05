package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-2049.zul")
class F70_ZK_2049Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
        val btn = jq(".z-button").eq(0)
        val btn1 = jq(".z-button").eq(1)
        click(btn)
        waitResponse()
        verifyTrue("open the menupopup", jq(".z-menupopup").exists)

        if (!isSafari)
          clickAt(btn, "0,0")
        else
          click(btn)
        waitResponse(true)
        verifyTrue("it will close", !jq(".z-menupopup").isVisible)

        contextMenu(btn1)
        waitResponse()
        verifyTrue("open the menupopup", jq(".z-menupopup").exists)
        if (!isSafari)
          contextMenuAt(btn1, "0,0")
        else
          contextMenu(btn1)
        waitResponse(true)
        verifyTrue("it will close", !jq(".z-menupopup").isVisible)
      })

  }
}