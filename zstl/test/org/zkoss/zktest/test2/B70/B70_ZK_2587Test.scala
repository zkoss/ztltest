package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2587.zul")
class B70_ZK_2587Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      val label = jq(".z-tabpanel .z-label")
      val tab = jq(".z-tab")
      dragdropToObject(label, tab, "0,0", "0,0")
      waitResponse(true)
      verifyEquals("dropped: 'in tabbox'", jq(".z-tab .z-tab-text").text())
    })
    
  }
}