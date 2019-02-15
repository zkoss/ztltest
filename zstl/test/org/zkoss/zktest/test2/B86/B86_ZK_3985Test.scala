package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B86_ZK_3985Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val listboxHeight = jq(".z-listbox").height()
      click(jq(".z-listcell").eq(0))
      waitResponse()
      verifyContains(getZKLog, listboxHeight + "")
      closeZKLog()

      val gridHeight = jq(".z-grid").height()
      click(jq(".z-cell").eq(0))
      waitResponse()
      verifyContains(getZKLog, gridHeight + "")
      closeZKLog()

      val treeHeight = jq(".z-tree").height()
      click(jq(".z-treecell").eq(0))
      waitResponse()
      verifyContains(getZKLog, treeHeight + "")
      closeZKLog()
    })
  }
}
