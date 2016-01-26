package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2929.zul")
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