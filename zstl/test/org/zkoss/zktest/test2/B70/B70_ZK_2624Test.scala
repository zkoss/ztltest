package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

class B70_ZK_2624Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      verifyEquals(3, jq(".z-paging").length());
    })
    
  }
}