package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1278.zul")
class B65_ZK_1278Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        click(jq(".z-treerow:contains(A)").toWidget().$n("icon"))
        waitResponse()
        click(jq(".z-treerow:contains(B)").toWidget().$n("icon"))
        waitResponse()
        val log = jq("#zk_log")
        verifyTrue("the log textbox should not appear the scrollbar", log.scrollTop() <= log.height())
      })

  }
}
