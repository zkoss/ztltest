package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B80-ZK-3250.zul")
class B80_ZK_3250Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        verScroll(jq(".z-listbox-body"), 0)
        waitResponse()
        verifyEquals("", getZKLog())

        click(jq("@button"))
        waitResponse()
        verifyEquals("", getZKLog())

        verScroll(jq(".z-listbox-body"), 100)
        waitResponse()
        verifyEquals("after setItemsInvalid_", getZKLog())
        closeZKLog()
        waitResponse()

        click(jq("@button"))
        waitResponse()
        verifyEquals("after setItemsInvalid_", getZKLog())
        closeZKLog()
        waitResponse()

        verScroll(jq(".z-listbox-body"), 0)
        waitResponse()
        verifyEquals("after setItemsInvalid_", getZKLog())
        closeZKLog()
        waitResponse()

        click(jq("@button"))
        waitResponse()
        verifyEquals("after setItemsInvalid_", getZKLog())
        closeZKLog()
        waitResponse()
      })
  }
}
