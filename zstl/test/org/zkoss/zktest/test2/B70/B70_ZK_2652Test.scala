package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2652.zul")
class B70_ZK_2652Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      var chosenbox = jq("@chosenbox");
      
      click(chosenbox);
      waitResponse();
      var originTop = jq(".z-chosenbox-popup").css("top");
      verScroll(jq("@window"), 0.7);
      waitResponse();
      verifyTrue(jq(".z-chosenbox-popup").css("top") < originTop);
    })
    
  }
}
