package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2551.zul")
class B70_ZK_2551Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
        var listbox = jq("@listbox")
        horScroll(listbox, 100)
        waitResponse()
        click(jq("@button"))
        waitResponse()
        verifyNotEquals(0, getScrollLeft(listbox.toWidget()))
      })
  }
}