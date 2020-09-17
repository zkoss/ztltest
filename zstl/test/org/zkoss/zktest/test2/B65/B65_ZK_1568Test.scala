package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1568.zul")
class B65_ZK_1568Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
        verifyTrue("Window 1, 3, 4, 5 should be visible while 2 should not", jq(".z-window-overlapped:contains(1)").exists())
        verifyFalse("Window 1, 3, 4, 5 should be visible while 2 should not", jq(".z-window-overlapped:contains(2)").exists())
        verifyTrue("Window 1, 3, 4, 5 should be visible while 2 should not", jq(".z-window-overlapped:contains(3)").exists())
        verifyTrue("Window 1, 3, 4, 5 should be visible while 2 should not", jq(".z-window-overlapped:contains(4)").exists())
        verifyTrue("Window 1, 3, 4, 5 should be visible while 2 should not", jq(".z-window-overlapped:contains(5)").exists())
      })
  }
}
