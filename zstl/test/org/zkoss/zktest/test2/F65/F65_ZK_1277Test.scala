package org.zkoss.zktest.test2.F65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F65-ZK-1277.zul")
class F65_ZK_1277Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val verifyHeight = (result: Int) =>
          List(".z-row", ".z-groupfoot") foreach { cls =>
            verifyEquals("each row should be the same height", jq(cls).outerHeight(), result)
          }
        verifyHeight(jq(".z-group").outerHeight())
        click(jq(".z-button:contains(Autopaging)"))
        waitResponse()
        verifyHeight(jq(".z-group").outerHeight())
      })

  }
}