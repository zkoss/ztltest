package org.zkoss.zktest.test2.F70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F70-ZK-2049.zul")
class F70_ZK_2049Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      val btn = jq(".z-button").eq(0)
      val btn1 = jq(".z-button").eq(1)
      clickAt(btn, "5,5")
      waitResponse()
      verifyEquals("open the menupopup", true, jq(".z-menupopup").exists)

      clickAt(btn, "1,1")
      waitResponse(true)
      verifyEquals("it will close", false, jq(".z-menupopup").isVisible)

      contextMenuAt(btn1, "5,5")
      waitResponse()
      verifyEquals("open the menupopup", true, jq(".z-menupopup").exists)
      contextMenuAt(btn1, "1,1")
      waitResponse(true)
      verifyEquals("it will close", false, jq(".z-menupopup").isVisible)
    })

  }
}