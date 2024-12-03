package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{IgnoreBrowsers, Tags}

// since mobile will always have a scrollbar, and default to be invisible, so we ignore them
@Tags(tags = "B70-ZK-2929.zul")
@IgnoreBrowsers("ios,android")
class B70_ZK_2929Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val buttons = jq(".z-combobox-button");
        click(buttons.eq(0));
        waitResponse(true);
        verifyFalse(hasHScrollbar(jq(".z-combobox-popup")));

        click(buttons.eq(1));
        waitResponse(true);
        verifyFalse(hasHScrollbar(jq(".z-combobox-popup")));
      })
  }
}