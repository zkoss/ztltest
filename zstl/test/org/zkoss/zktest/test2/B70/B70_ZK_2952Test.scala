package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2952.zul")
class B70_ZK_2952Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val textbox = jq(".z-textbox");
        focus(textbox);
        blur(textbox);
        sleep(500);
        val errorbox = jq(".z-errorbox");
        val errorboxCloseBtn = errorbox.find(".z-errorbox-close");
        click(errorboxCloseBtn);
        sleep(50);
        verifyTrue(!errorbox.isVisible() && !errorbox.is(":animated"));
      })

  }
}