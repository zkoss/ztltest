package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-3237.zul")
class B80_ZK_3237Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        `type`(jq(".z-combobox-input"), "a")
        `type`(jq(".z-textbox"), "aa")
        waitResponse()

        verifyEquals("aa", jq(".z-textbox").`val`())
    })
  }
}
