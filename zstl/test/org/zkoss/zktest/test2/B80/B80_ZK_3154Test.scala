package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

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

