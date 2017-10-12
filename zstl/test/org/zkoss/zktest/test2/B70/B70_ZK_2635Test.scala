package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2635.zul")
class B70_ZK_2635Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      mouseOver(jq(".z-nav a"))
      waitResponse()
      click(jq(".z-nav").first)
      waitResponse()
      val left = jq(".z-nav-popup").css("left")
      click(jq(".z-navitem").first)
      waitResponse()
      verifyEquals(jq(".z-nav-popup").css("left"), left)
    })
    
  }
}
