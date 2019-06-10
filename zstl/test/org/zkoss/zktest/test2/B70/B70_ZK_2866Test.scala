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
        verifyTolerant(ahd.eq(2).width(), clmn.eq(0).width() + clmn.eq(1).width() + clmn.eq(2).width(), 3)
        verifyTolerant(ahd.eq(3).width(), clmn.eq(3).width() + clmn.eq(4).width() + clmn.eq(5).width(), 3)
        verifyTolerant(ahd.eq(4).width(), clmn.eq(6).width() + clmn.eq(7).width() + clmn.eq(8).width(), 3)
        verifyTolerant(ahd.eq(5).width(), clmn.eq(9).width() + clmn.eq(10).width() + clmn.eq(11).width(), 3)
      }
    })
  }
}
