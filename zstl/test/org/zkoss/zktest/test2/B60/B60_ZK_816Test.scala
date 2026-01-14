package org.zkoss.zktest.test2.B60

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

@Tags(tags = "B60-ZK-816.zul")
@IgnoreBrowsers("ios,android")
class B60_ZK_816Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        mouseOver(jq(".z-label:contains(new label):eq(2)"))
        waitResponse()
        sleep(2000)
        verifyTrue(jq(".z-popup:contains(this is tool tip)").eq(0).is(":visible"))
        mouseOver(jq(".z-label:contains(new label):eq(3)"))
        waitResponse()
        sleep(2000)
        verifyTrue(jq(".z-popup:contains(this is tool tip)").eq(1).is(":visible"))
      })

  }
}
