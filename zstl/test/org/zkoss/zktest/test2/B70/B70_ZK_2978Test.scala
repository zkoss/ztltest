package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Dimension
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2978.zul")
class B70_ZK_2978Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        setWindowSize(getWindowWidth(), 400)
        sleep(500);

        val groupboxCaption = jq(".z-caption");
        click(groupboxCaption);

        waitResponse(true);

        verifyTrue(hasVScrollbar(jq(".menuGroupboxContainer")));
      })

  }
}