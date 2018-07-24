package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2394.zul")
class B70_ZK_2394Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
    runZTL(() => {
        click(jq("@button"))
        waitResponse()
        verifyContains(getZKLog(), "Yes\nYes")
      })
  }
}