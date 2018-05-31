package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2468.zul")
class B70_ZK_2468Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        verifyTrue(jq(".z-grid-body").width.equals(jq(".z-grid-body > table").width))
      })

  }
}