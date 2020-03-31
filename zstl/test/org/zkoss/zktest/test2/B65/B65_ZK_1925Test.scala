package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1925.zul")
class B65_ZK_1925Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
    runZTL(() => {
        for (index <- 0 to 1) {
          verifyTrue("The Red div should have the same height, as the green divs next to them",
            jq(".z-div:contains(inline)").eq(index).height() ==
              jq(".z-div:contains(sclass)").eq(index).height())
        }
      })
  }
}