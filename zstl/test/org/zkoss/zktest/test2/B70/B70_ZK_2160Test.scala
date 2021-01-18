package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

@Tags(tags = "B70-ZK-2306.zul")
@IgnoreBrowsers("ios,android")
class B70_ZK_2160Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        windowResizeTo(1024, 300)
        waitResponse(true)

        val menu = jq("@menu:visible");
        click(menu);
        waitResponse();

        val popup = jq("@menupopup:visible");
        val rightOffset = popup.width() + popup.offsetLeft();
        println(rightOffset + "," + menu.offsetLeft());
        verifyTrue("Menu popup should be at the left side of menu.", rightOffset < menu.offsetLeft());
        sleep(2500);

        verifyTrue("Menu popup should be at the same position after blocking 2 seconds.", rightOffset == popup.width() + popup.offsetLeft());
      })

  }
}