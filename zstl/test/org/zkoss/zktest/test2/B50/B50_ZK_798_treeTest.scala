package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B50-ZK-798-tree.zul")
class B50_ZK_798_treeTest extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(() => {
      // simulate user scroll action
      jq("body").toElement().set("scrollTop", 4000)
      sleep(200)
      click(jq(".z-treerow:contains(199)"))
      waitResponse()
      sleep(200)
      click(jq(".z-button:contains(invalidate)"))
      sleep(200)
      waitResponse()

      verifyNotEquals("The scrollTop shouldn't move to first listitem after click the button.", jq("body").css("scrollTop"), 0)
    })

  }
}
