package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1918.zul")
class B65_ZK_1918Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      verifyFalse("no exception", jq(".z-window-modal").exists());
    })
  }
}