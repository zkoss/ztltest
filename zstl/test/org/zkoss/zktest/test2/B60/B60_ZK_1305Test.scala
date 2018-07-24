package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1305.zul")
class B60_ZK_1305Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
    runZTL(
      () => {
        val test0 = jq(".z-listitem:contains(test0)")
        click(test0)
        waitResponse()

        verifyTrue("should see 'select index: 0' message showed.", jq(".z-label:contains(select index: 0)").exists())
        dragAndDrop(test0, "20, 20")
        waitResponse()
        verifyContains("Should be able to drag test0 item.", getZKLog(), "z-drop-text")
      })

  }
}
