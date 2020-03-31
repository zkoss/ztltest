package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B50-ZK-975.zul")
class B50_ZK_975Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
    runZTL(() => {
        val width0 = jq(".z-textbox:eq(0)").width()
        val width1 = jq(".z-textbox:eq(1)").width()
        val width2 = jq(".z-textbox:eq(2)").width()

        verifyTolerant(width0, width1, 10)
        verifyTolerant(width0, width2, 10)
        verifyTolerant(width1, width2, 10)
      })

  }
}
