package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2590.zul")
class B70_ZK_2590Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(
    () => {
      var input = jq(".z-combobox-input");
      sendKeys(input, "1");
      waitResponse();
      verifyEquals("1A", input.`val`());
    })
    
  }
}