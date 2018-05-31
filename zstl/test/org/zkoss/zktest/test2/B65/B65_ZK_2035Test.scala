package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-2035.zul")
class B65_ZK_2035Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      click(jq(".z-panel").toWidget().$n("exp"))
      waitResponse
      verifyTrue("should not see error message", !jq(".z-error").exists)
    })

  }
}