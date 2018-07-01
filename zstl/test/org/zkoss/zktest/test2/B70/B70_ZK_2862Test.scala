package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2862.zul")
class B70_ZK_2862Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val listbox = jq("$lb").eq(0)
        val opt = listbox.children().first
        click(listbox)
        waitResponse()
        click(opt)
        waitResponse()
        verifyEquals("fasfsaf", listbox.`val`())
      })
  }
}