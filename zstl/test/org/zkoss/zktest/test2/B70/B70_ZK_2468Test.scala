package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2468.zul")
class B70_ZK_2468Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        verifyEquals(jq(".z-grid-body").width(), jq(".z-grid-body > table").width())
      })

  }
}