package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1997.zul")
class B65_ZK_1997Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      val position = "2,2"
      val src = jq(".z-panel")
      val target = jq(".z-panel")
      val position1 = "10,10"
      dragdropToObject(src, target, position, position1)
      waitResponse()
      verifyFalse("You should not see any dialog.", jq(".z-window").exists)
    })
  }
}