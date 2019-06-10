package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2129.zul")
class B70_ZK_2129Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        val tree = jq(".z-tree")
        val h = tree.height()
        nativeFrozenScroll(tree, 200)
        verifyTrue("height of the tree won't be changed", h == tree.height())
      })
  }
}