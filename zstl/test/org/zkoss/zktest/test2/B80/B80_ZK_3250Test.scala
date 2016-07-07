package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-3250.zul")
class B80_ZK_3250Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        verScroll(jq(".z-listbox-body"), 0)
        waitResponse()
        verifyTrue(getZKLog.equalsIgnoreCase(""))

        click(jq("@button"))
        waitResponse()
        verifyTrue(getZKLog.equalsIgnoreCase(""))

        verScroll(jq(".z-listbox-body"), 100)
        waitResponse()
        verifyTrue(getZKLog.trim.equalsIgnoreCase("after setItemsInvalid_"))

        click(jq("@button"))
        waitResponse()
        verifyTrue(getZKLog.trim.equalsIgnoreCase("after setItemsInvalid_\nafter setItemsInvalid_"))

        verScroll(jq(".z-listbox-body"), 0)
        waitResponse()
        verifyTrue(getZKLog.trim.equalsIgnoreCase("after setItemsInvalid_\nafter setItemsInvalid_\nafter setItemsInvalid_"))

        click(jq("@button"))
        waitResponse()
        verifyTrue(getZKLog.trim.equalsIgnoreCase("after setItemsInvalid_\nafter setItemsInvalid_\nafter setItemsInvalid_"))
      })
  }
}
