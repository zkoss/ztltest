package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1425.zul")
class B65_ZK_1425Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val footer1 = jq("@listfooter:eq(0)")
        val ft1Width = footer1.width()

        click(jq("@button"))
        waitResponse()
        verifyTrue(footer1.width() < ft1Width)
        verifyTrue(footer1.isVisible)

        click(jq("@button"))
        waitResponse()
        verifyEquals(ft1Width, footer1.width())
    })

  }
}
