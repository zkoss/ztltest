package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * Created by wenning on 1/21/16.
  */
@Tags(tags = "B70-ZK-2866.zul")
class B70_ZK_2866Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      val clmn = jq(".z-column")
      val ahd = jq(".z-auxheader")
      for (i <- 1 to 11) {
        frozenScroll(jq("@grid"), i)
        var cwidth = 0
        for (j <- 0 to 2) {
          cwidth += clmn.eq(j).outerWidth()
        }
        verifyTolerant(ahd.eq(2).outerWidth(), cwidth, 2)
        cwidth = 0
        for (j <- 3 to 5) {
          cwidth += clmn.eq(j).outerWidth()
        }
        verifyTolerant(ahd.eq(3).outerWidth(), cwidth, 2)
        cwidth = 0
        for (j <- 6 to 8) {
          cwidth += clmn.eq(j).outerWidth()
        }
        verifyTolerant(ahd.eq(4).outerWidth(), cwidth, 2)
        cwidth = 0
        for (j <- 9 to 11) {
          cwidth += clmn.eq(j).outerWidth()
        }
        verifyTolerant(ahd.eq(5).outerWidth(), cwidth, 2)
      }
    })
  }

}
