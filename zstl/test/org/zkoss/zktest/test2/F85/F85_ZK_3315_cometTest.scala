package org.zkoss.zktest.test2.F85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "F85-ZK-3315-comet.zul")
class F85_ZK_3315_cometTest extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      `type`(jq("@textbox"), "ZTL Test")
      keyPressEnter(jq("@textbox"))
      waitResponse()

      verifyContains("Injected text should be printed if hook is successful", getZKLog, "[SP] injected.")
      verifyContains("Injected text should be printed if hook is successful", getZKLog, "[SP] success")
    })
  }
}
