package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2514.zul")
class B70_ZK_2514Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      val vsplitter = jq(".z-splitter-horizontal")
      dragdropTo(vsplitter, "3,3", "-200,3")
      waitResponse(true)
      val oldWidth = jq(".z-vbox").width()
      dragdropTo(vsplitter, "3,3", "230,3")
      verifyTrue(jq(".z-vbox").width() - oldWidth > 0)
      waitResponse(true)
      val hsplitter = jq(".z-splitter-vertical")
      val oldHeight = jq(".z-vbox").height()
      dragdropTo(hsplitter, "3,3", "3,-100")
      verifyTrue(jq(".z-vbox").height() - oldHeight == 0)

    })

  }
}