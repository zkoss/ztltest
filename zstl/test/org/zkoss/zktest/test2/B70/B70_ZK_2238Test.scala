package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2238.zul")
class B70_ZK_2238Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val tree = jq(".z-tree")
        verScroll(tree, 100)
        click(jq(".z-treerow:contains(99)").toWidget().$n("open"))
        waitResponse()
        verifyTrue("the tree should not out of view", tree.isVisible())
      })

  }
}