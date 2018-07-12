package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-3207.zul")
class B80_ZK_3207Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        val h = jq(".z-groupbox").get(0).attr("offsetHeight")

        click(jq(".z-button"))
        waitResponse()

        verifyEquals(h, jq(".z-groupbox").get(0).attr("offsetHeight"))
      })
  }
}
