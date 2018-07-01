package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3946.zul")
class B85_ZK_3946Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("@button:contains(add tree item):eq(0)"))
      waitResponse()
      verifyFalse(jq("#zk_log").exists())

      click(jq("@button:contains(add tree item):eq(1)"))
      waitResponse()
      verifyFalse(jq("#zk_log").exists())

      click(jq("@button:contains(open):eq(0)"))
      waitResponse()
      verifyTrue(jq("@listbox").isVisible)

      click(jq("@button:contains(open):eq(1)"))
      waitResponse()
      verifyTrue(jq("@textbox").isVisible)
    })
  }
}
