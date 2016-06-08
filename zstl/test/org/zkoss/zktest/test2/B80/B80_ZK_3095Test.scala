package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenning on 5/30/16.
  */
class B80_ZK_3095Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        val miow = jq(".z-menuitem").get(0).get("offsetWidth")
        verifyFalse(jq(".z-menubar-left").isVisible())
        verifyFalse(jq(".z-menubar-right").isVisible())
        System.out.println(miow);
        windowResizeTo((Integer.parseInt(miow) + 12) * 7 + 10, 500)
        waitResponse(true)
        verifyTrue(jq(".z-menubar-left").isVisible())
        verifyTrue(jq(".z-menubar-right").isVisible())
      }
    )
  }
}
