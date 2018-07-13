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

        val position = "2,2"
        val test = jq(".z-listitem:contains(test):eq(1)")

        mouseMoveAt(test0, position)
        waitResponse()

        mouseDownAt(test0, position)
        waitResponse()

        mouseMoveAt(test, position)
        waitResponse()
        waitResponse()

        verifyTrue("Should be able to drag test0 item.", jq(".z-drop-ghost").exists())
      })

  }
}
