package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B80-ZK-3184.zul")
class B80_ZK_3184Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(
      () => {
        click(jq(".z-button"))
        waitResponse()
        verifyEquals("true", zk(".z-grid .z-label:contains(\"Target\")").eval("isRealScrollIntoView()"))
      })
  }
}
