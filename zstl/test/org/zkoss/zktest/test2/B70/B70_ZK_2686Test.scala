package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

@Tags(tags = "B70-ZK-2686.zul")
@IgnoreBrowsers("ie8")
class B70_ZK_2686Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        windowResizeTo(1024, 768)
        waitResponse()
        click(jq("$click1"))
        waitResponse()
        click(jq("$click2"))
        waitResponse()
        windowResizeTo(1024, 760)
        waitResponse()
        verifyTrue(jq(".z-scrollbar-vertical-embed:eq(0)").exists())
        verifyFalse(jq(".z-scrollbar-vertical-embed:eq(1)").exists())
      })
  }
}