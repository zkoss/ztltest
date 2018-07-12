package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3835.zul")
class F85_ZK_3835Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      val tree = jq("@tree")
      val content = jq("@tree .z-tree-body")
      val contentH1 = content.scrollHeight()

      click(jq(".z-treerow:eq(0)").toWidget.$n("open"))
      waitResponse()
      val contentH2 = content.scrollHeight()
      verifyTrue("When opened node, the height should be bigger", contentH2 > contentH1)

      verScroll(tree, 100)
      click(jq(".z-treerow:last").toWidget.$n("open"))
      waitResponse()
      val contentH3 = content.scrollHeight()
      verifyTrue("When opened node, the height should be bigger", contentH3 > contentH2)

      verScroll(tree, 0)
      click(jq(".z-treerow:eq(0)").toWidget.$n("open"))
      waitResponse()
      val contentH4 = content.scrollHeight()
      verifyEquals("When closed node, the height should remain", contentH4, contentH2)
    })
  }
}
