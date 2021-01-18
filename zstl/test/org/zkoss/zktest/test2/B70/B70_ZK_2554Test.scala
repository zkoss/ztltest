package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

@Tags(tags = "B70-ZK-2554.zul")
@IgnoreBrowsers("ios,android")
class B70_ZK_2554Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        var textbox = jq("@textbox");
        contextMenu(textbox);
        waitResponse();
        mouseOver(textbox);
        waitResponse();

        verifyTrue(jq(".z-popup").exists());
      })

  }
}