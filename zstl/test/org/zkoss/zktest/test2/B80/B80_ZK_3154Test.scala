package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-3049.zul")
class B80_ZK_3154Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        waitResponse()
        verifyFalse(jq(".z-tree-paging-bottom .z-paging").isVisible)
    })
  }
}

