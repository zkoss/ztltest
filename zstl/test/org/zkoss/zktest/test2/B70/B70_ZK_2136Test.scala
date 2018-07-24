package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{SeleniumOnly, Tags}

@Tags(tags = "B70-ZK-2136.zul")
class B70_ZK_2136Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(() => {
      dragAndDrop(jq("$item1"), "2,100")
      waitResponse(true);
      sleep(500);
      verifyContains("the detail text of the paging bar should be updated", getZKLog(), "true")
    })
  }
}