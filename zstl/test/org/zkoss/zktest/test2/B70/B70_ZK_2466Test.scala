package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2466.zul")
class B70_ZK_2466Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      var btn = jq(".z-button");
      click(btn);
      waitResponse();
      val AAA = jq(".z-column-content").first().text();      
      verifyTrue("AAA".equals(AAA));
      
    })
    
  }
}