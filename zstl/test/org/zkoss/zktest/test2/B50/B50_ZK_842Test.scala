package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B50-ZK-842.zul")
class B50_ZK_842Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        `type`(jq(".z-intbox"), "-1")
        waitResponse()
        verifyTrue("should see an error message.", jq(".z-errorbox").exists())
      })

  }
}
