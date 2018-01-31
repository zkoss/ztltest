package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2589.zul")
class B70_ZK_2589Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      var tree = jq("@tree");
      verScroll(tree, 10);
      
      click(jq(".z-treerow .z-tree-icon").eq(7));
      waitResponse();
      click(jq(".z-treerow .z-tree-icon").eq(7));
      waitResponse();
      verScroll(tree, 90);
      waitResponse();
      sleep(1000);
      verScroll(tree, 100);
      waitResponse();
      sleep(1000);
      verifyTrue(jq(".z-treerow").last().isVisible());
      verifyTrue(jq(".z-treerow").last().find(".z-label").eq(0).text() == "test-60");
    })
    
  }
}