package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1642.zul")
class B65_ZK_1642Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
        verifyTolerant(jq(".z-treecol:eq(1)").width(), jq(".z-treecell:eq(1)").width(), 3)
        verifyTolerant(jq(".z-treecol:eq(2)").width(), jq(".z-treecell:eq(2)").width(), 3)
      })
  }
}