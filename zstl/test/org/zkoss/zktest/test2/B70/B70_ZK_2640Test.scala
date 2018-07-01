package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2640.zul")
class B70_ZK_2640Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var textbox = jq(".z-listbox .z-textbox")
        typeKeys(textbox.first, "a");
        waitResponse();
        for (i <- 0 to 10) {
          if (textbox.eq(i) != null) {
            sendKeys(textbox.eq(i), Keys.TAB);
            waitResponse();
          }
        }
        verifyTrue(jq(".z-listbox .z-scrollbar").css("left") != 0);

        textbox = jq(".z-grid .z-textbox");
        typeKeys(textbox.first, "a");
        waitResponse();
        for (i <- 0 to 10) {
          if (textbox.eq(i) != null) {
            sendKeys(textbox.eq(i), Keys.TAB);
            waitResponse();
          }
        }
        verifyTrue(jq(".z-grid .z-scrollbar").css("left") != 0);

        textbox = jq(".z-tree .z-textbox");
        typeKeys(textbox.first, "a");
        waitResponse();
        for (i <- 0 to 10) {
          if (textbox.eq(i) != null) {
            sendKeys(textbox.eq(i), Keys.TAB);
            waitResponse();
          }
        }
        verifyTrue(jq(".z-tree .z-scrollbar").css("left") != 0);
      })

  }
}