package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1297.zul")
class B65_ZK_1297Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
        // 1. The height of Listbox should be smaller than Tabbox.
        val height = jq("@listbox").height()
        verifyTrue("The height of Listbox should be smaller than Tabbox", jq("@listbox").height() < jq("@tabbox").height())

        //2. Click "Add" button, the height of listbox should not change a lot.
        click(jq("@button"))
        waitResponse

        val limit = 10
        val newHeight = jq("@listbox").height()
        val isbound = newHeight <= height + limit && newHeight >= height - limit
        verifyTrue("the height of listbox should not change a lot.", isbound)

      })


  }
}