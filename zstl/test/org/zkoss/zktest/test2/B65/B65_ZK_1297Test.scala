package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1297.zul")
class B65_ZK_1297Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      //1. Click "Add" button, the height of listbox should not change a lot.
      val height = jq("@listbox").height()
      click(jq("@button"))
      waitResponse
      val newHeight = jq("@listbox").height()
      verifyTolerant(height, newHeight, 10)
    })
  }
}