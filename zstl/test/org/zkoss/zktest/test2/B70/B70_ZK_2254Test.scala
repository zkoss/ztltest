package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2254.zul")
class B70_ZK_2254Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        click(jq(".z-button"))
        waitResponse()
        sleep(5000)
        verScroll(jq(".z-tree").toWidget(), 1.0)
        verifyTrue("the 'c59' label should be there.", jq(".z-label:contains(c59)").exists)
      })
  }
}