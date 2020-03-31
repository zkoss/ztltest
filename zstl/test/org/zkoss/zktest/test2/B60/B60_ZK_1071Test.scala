package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1071.zul")
class B60_ZK_1071Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val bb = jq(".z-bandbox")
        click(bb)
        waitResponse(true)
        click(jq(".z-listcell:contains(B)"))
        waitResponse()
        verifyTrue("the bandbox value should become 'B'",
          bb.toWidget().$n("real").attr("value") == "B")
        click(jq(".z-button:eq(0)"))
        waitResponse()
        verifyContains("it should pop up a 'value:B' messagebox",
          jq(".z-messagebox-window .z-label").text(), "value:B")
      })
  }
}