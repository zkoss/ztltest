package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1679.zul")
class B65_ZK_1679Test extends ZTL4ScalaTestCase {
  def testClick() = {
    runZTL(() => {
      dragdropTo(jq(".z-window-overlapped"), "169, 104", "200, 140")
      waitResponse()
      verifyTrue("you should not see green background bar expand to window size", getEval("Math.abs(" + jq(".z-hlayout").height() + "-" + 50 + ") < 5"))
      verifyTrue("you should not see green background bar expand to window size", getEval("Math.abs(" + jq(".z-hlayout").width() + "-" + 105 + ") < 5"))
    })
  }
}