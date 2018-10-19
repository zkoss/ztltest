package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2589.zul")
class B70_ZK_2589Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      val tree = jq(".z-tree-body");
      verScrollAbs(tree, (tree.scrollHeight() * .1).intValue());

      click(jq(".z-treerow .z-tree-icon").eq(7));
      waitResponse();
      click(jq(".z-treerow .z-tree-icon").eq(7));
      waitResponse();
      verScrollAbs(tree, (tree.scrollHeight() * .9).intValue());
      waitResponse();
      sleep(1000);
      verScrollAbs(tree, tree.scrollHeight());
      waitResponse();
      sleep(1000);
      verifyTrue(jq(".z-treerow").last().isVisible());
      verifyTrue(jq(".z-treerow").last().find(".z-label").eq(0).text() == "test-60");
    })

  }
}