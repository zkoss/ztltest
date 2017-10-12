package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1706.zul")
class B65_ZK_1706Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        verifyTolerant(jq(".z-button:contains(Go):eq(0)").width(), jq(".z-button:contains(Go):eq(1)").width(), 4)
      })

  }
}