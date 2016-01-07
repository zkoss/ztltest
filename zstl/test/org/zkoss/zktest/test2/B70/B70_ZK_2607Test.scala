package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2607.zul")
class B70_ZK_2607Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      var btn = jq("@button")
      var options = jq(".z-selectbox option")
      verifyEquals(2, options.length())
      verifyEquals("renderer1", options.eq(0).text())
      verifyEquals("renderer1", options.eq(1).text())
      click(btn)
      waitResponse()
      verifyEquals(2, options.length())
      verifyEquals("renderer2", options.eq(0).text())
      verifyEquals("renderer2", options.eq(1).text())
    })
    
  }
}