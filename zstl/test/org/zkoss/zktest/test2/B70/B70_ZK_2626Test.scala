package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2626.zul")
class B70_ZK_2626Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      var tree1 = jq(".z-tree-body .z-treecell-content").eq(0);
      var tree2 = jq(".z-tree-body.z-tree-autopaging .z-treecell-content").eq(0);
      verifyTolerant(20, tree1.height(), 2);
      verifyTolerant(20, tree2.height(), 2);
    })
    
  }
}