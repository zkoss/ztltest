package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2519.zul")
class B70_ZK_2519Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      var changeBtn = jq(".z-button:contains(change)");
      click(changeBtn);
      waitResponse();
      verifyTrue(jq(".z-label:contains(tag Label)").last().length() > 0);
      waitResponse();
      var hideBtn = jq(".z-button:contains(hide)");
      click(hideBtn);
      waitResponse();
      verifyTrue(jq(".z-error").length() < 1);
      
    })
    
  }
}