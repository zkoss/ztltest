package org.zkoss.zktest.test2.B96

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

/**
  * @author leon
  */
@IgnoreBrowsers("ff,ie11,ie10,ie9,edge_legacy")
class B96_ZK_4929Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq(".z-bandbox-button"));
      waitResponse();
      sleep(1200);
      verifyTrue("bandpopup shall not closed with keyCode 0", jq(".z-bandbox-popup").isVisible());
    })
  }
}
