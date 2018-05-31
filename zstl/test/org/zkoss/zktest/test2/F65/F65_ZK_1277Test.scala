package org.zkoss.zktest.test2.F65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "F65-ZK-1277.zul")
class F65_ZK_1277Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      val verifyHeight = (result: Int) =>
        List(".z-row", ".z-groupfoot") foreach { cls =>
          verifyTolerant(jq(cls).outerHeight(), result, 3) //due to new theme border
        }
      verifyHeight(jq(".z-group").outerHeight())
      click(jq(".z-button:contains(Autopaging)"))
      waitResponse()
      verifyHeight(jq(".z-group").outerHeight())
    })

  }
}