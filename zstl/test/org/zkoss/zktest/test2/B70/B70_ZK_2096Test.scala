package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2096.zul")
class B70_ZK_2096Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val btn = jq(".z-button")
        for (n <- 1 to 5) {
          click(btn)
          waitResponse()
        }
        verifyTrue("the z-treecols-bar should not be in front of treecol", !jq("[id$=hdfaker-bar] + [id$=hdfaker]").exists)
      })

  }
}