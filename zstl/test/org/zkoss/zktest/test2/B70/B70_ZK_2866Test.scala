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
        verifyTolerant(ahd.eq(2).outerWidth(), clmn.eq(0).outerWidth() + clmn.eq(1).outerWidth() + clmn.eq(2).outerWidth(), 2)
        verifyTolerant(ahd.eq(3).outerWidth(), clmn.eq(3).outerWidth() + clmn.eq(4).outerWidth() + clmn.eq(5).outerWidth(), 2)
        verifyTolerant(ahd.eq(4).outerWidth(), clmn.eq(6).outerWidth() + clmn.eq(7).outerWidth() + clmn.eq(8).outerWidth(), 2)
        verifyTolerant(ahd.eq(5).outerWidth(), clmn.eq(9).outerWidth() + clmn.eq(10).outerWidth() + clmn.eq(11).outerWidth(), 2)
      }
    })
  }
}
