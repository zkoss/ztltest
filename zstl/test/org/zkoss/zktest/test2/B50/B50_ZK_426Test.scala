package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B50-ZK-426.zul")
class B50_ZK_426Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        sendKeys(jq(".z-intbox").eq(1), Keys.TAB)
        waitResponse()
        `type`(jq(".z-intbox").eq(1), "123")
        waitResponse()

        verifyEquals("123", jq(".z-intbox").eq(1).`val`())
      })
  }
}
