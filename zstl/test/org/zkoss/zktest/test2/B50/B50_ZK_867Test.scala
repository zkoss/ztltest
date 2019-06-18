package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B50-ZK-867.zul")
class B50_ZK_867Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val product0 = jq(".z-grid:eq(0) .z-row:contains(Kyocera)")
        click(widget(product0.find("@detail")).$n("icon"))
        waitResponse()
        val detail0 = product0.next()

        val product1 = jq(".z-grid:eq(1) .z-row:contains(Kyocera)")
        click(widget(product1.find("@detail")).$n("icon"))
        waitResponse()
        val detail1 = product1.next()

        verifyNotEquals("the style of the content of second detail should be different with first detail", detail0.css("background-color"), detail1.css("background-color"))
      })

  }
}
