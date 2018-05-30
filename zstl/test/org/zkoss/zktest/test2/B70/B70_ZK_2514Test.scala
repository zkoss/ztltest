package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2514.zul")
class B70_ZK_2514Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      val vsplitter = jq(".z-splitter-horizontal")
      var startL = vsplitter.positionLeft()
      var startT = vsplitter.positionTop()
      val endL = startL - 200;
      dragdropTo(vsplitter, startL + "," + startT, endL + "," + startT)
      waitResponse(true)
      val oldWidth = jq(".z-vbox").width()
      startL = vsplitter.positionLeft()
      startT = vsplitter.positionTop()
      dragdropTo(vsplitter, startL + "," + startT, (startL + 30) + "," + startT)
      verifyTrue(jq(".z-vbox").width() - oldWidth > 0)
      waitResponse(true)
      val hsplitter = jq(".z-splitter-vertical")
      val oldHeight = jq(".z-vbox").height()
      startL = hsplitter.positionLeft()
      startT = hsplitter.positionTop()
      val endT = startT - 100
      dragdropTo(hsplitter, startL + "," + startT, startL + "," + endT)
      verifyTrue(jq(".z-vbox").height() - oldHeight == 0)
      
    })
    
  }
}