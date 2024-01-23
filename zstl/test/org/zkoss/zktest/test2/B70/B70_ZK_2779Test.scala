package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2779.zul")
class B70_ZK_2779Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      val msg_1 = "selection count after unchecked is 22"
      val msg_2 = msg_1 + "\nselection count after unchecked is 11"
      val msg_3 = msg_2 + "\nselection count after unchecked is 0"
      val msg_4 = msg_3 + "\nselection count after unchecked is 11"
      click(jq(".z-treerow-checkbox:eq(0)"))
      waitResponse()
      verifyEquals(msg_1, getZKLog())
      click(jq(".z-treerow-checkbox:eq(1)"))
      waitResponse()
      verifyEquals(msg_2, getZKLog())
      click(jq(".z-treerow-checkbox:eq(2)"))
      waitResponse()
      verifyEquals(msg_3, getZKLog())
      click(jq(".z-treerow-checkbox:eq(2)"))
      waitResponse()
      verifyEquals(msg_4, getZKLog())
    })
  }
}