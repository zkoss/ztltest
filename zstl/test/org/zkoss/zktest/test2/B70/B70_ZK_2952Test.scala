package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2952.zul")
class B70_ZK_2952Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val textbox = jq(".z-textbox")
        click(textbox)
        click(jq("body"))
        sleep(500)
        val errorbox = jq(".z-errorbox")
        val errorboxCloseBtn = errorbox.find(".z-errorbox-close")
        click(errorboxCloseBtn)
        sleep(500)
        verifyFalse(errorbox.isVisible())
      })

  }
}