package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZK

@Tags(tags = "B65-ZK-1540.zul")
class B65_ZK_1540Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(() => {
      val shadow = jq(".z-datebox").css("box-shadow")
      var expectResult = "rgb(0, 165, 225) 0px 0px 6px 0px"
      if (isIE || isEdge)
        expectResult = "0px 0px 6px #00a5e1"
      verifyEquals("Should see a blue shadow surrounding the datebox completely.", expectResult, shadow)
    })

  }
}
