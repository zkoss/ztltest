package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2358.zul")
class B70_ZK_2358Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      val cell = jq("@listitem").first().find("@listcell").last();
      val header = jq("@listheader").last();

      // Column borders shouldn't to be mis-aligned to listbox header's border.
      verifyTolerant(cell.offsetLeft(), header.offsetLeft(), 1);
    })
    
  }
}
