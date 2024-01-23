package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B50-ZK-812.zul")
class B50_ZK_812Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      verifyFalse("should not see java error.", jq(".z-window-modal").exists())
    })
  }
}