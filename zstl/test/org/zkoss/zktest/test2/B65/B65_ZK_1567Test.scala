package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1567.zul")
class B65_ZK_1567Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
      click(jq(".z-menu:contains(More)"))
      waitResponse()
      println(jq(".z-menu").offsetLeft(), jq(".z-menupopup").offsetLeft())
      //The menupopup should align with the left of 'More' menu
      verifyTolerant(jq(".z-menu").offsetLeft(), jq(".z-menupopup").offsetLeft(), 3)
    })

  }
}
