package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B85-ZK-3980.zul")
class B85_ZK_3980Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      click(jq("@button"))
      waitResponse()
      verifyTrue("Notification should appear", jq("@notification").isVisible)
      verifyFalse("Should be no javascript error", jq("#zk_log").exists())

      click(jq("@label"))
      waitResponse()
      verifyFalse("Notification should disappear", jq("@notification").isVisible)
    })
  }
}
