package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-2019.zul")
class B65_ZK_2019Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var cb = jq(".z-chosenbox").toWidget()
        sendKeys(cb.$n("inp"), "oh")
        waitResponse(true)
        sleep(300)
        verifyTrue("Your will see 'John (john@company.org)' option.", jq(".z-chosenbox-option:contains(john@company.org)").exists)
      })

  }
}