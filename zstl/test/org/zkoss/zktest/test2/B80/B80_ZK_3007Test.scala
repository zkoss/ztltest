package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-3007.zul")
class B80_ZK_3007Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        val grid = jq("@grid").eq(0)
        verifyTrue(grid.exists())
        for (i <- 0 to 3) {
          val c1 = jq("@column").eq(i)
          val rc1 = jq("@row").eq(0).children().eq(i)
          verifyEquals(c1.outerWidth(), rc1.outerWidth())
        }
      })
  }
}

