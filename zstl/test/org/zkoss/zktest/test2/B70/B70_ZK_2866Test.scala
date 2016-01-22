package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * Created by wenning on 1/21/16.
 */
@Tags(tags = "B70-ZK-2866.zul")
class B70_ZK_2866Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      var clmn = jq(".z-column")
      var ahd = jq(".z-auxheader")
      for (i <- 1 to 11) {
        frozenScroll(jq("@grid"), i)
        var width = 0
        for (j <- 0 to 2) {
          width = width + clmn.eq(j).outerWidth()
        }
        verifyEquals(ahd.eq(2).outerWidth(), width)
        width = 0
        for (j <- 3 to 5) {
          width = width + clmn.eq(j).outerWidth()
        }
        verifyEquals(ahd.eq(3).outerWidth(), width)
        width = 0
        for (j <- 6 to 8) {
          width = width + clmn.eq(j).outerWidth()
        }
        verifyEquals(ahd.eq(4).outerWidth(), width)
        width = 0
        for (j <- 9 to 11) {
          width = width + clmn.eq(j).outerWidth()
        }
        verifyEquals(ahd.eq(5).outerWidth(), width)
      }
    })
  }

}
