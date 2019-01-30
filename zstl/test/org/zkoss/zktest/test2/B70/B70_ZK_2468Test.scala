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
        val columns = jq(".z-column")
        val cells = jq(".z-row:eq(0) > .z-cell")
        for (i <- 0 to 2) {
          verifyTolerant(columns.eq(i).offsetLeft(), cells.eq(i).offsetLeft(), 1)
        }
      })

  }
}