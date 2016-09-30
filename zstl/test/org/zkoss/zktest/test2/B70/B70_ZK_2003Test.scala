package org.zkoss.zktest.test2.B70

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

class B70_ZK_2003Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(
      () => {
        val split = jq(".z-north").toWidget.$n("split")
        List("combobox", "bandbox") foreach { comp =>
          val wgt = jq(".z-" + comp).toWidget
          val wgtpp = wgt.$n("pp")
          click(wgt.$n("btn"))
          waitResponse()
          verifyTrue("the " + comp + " popup will show up", jq(wgtpp).isVisible)
          val p = "2,2"
          val np = "2,4"
          mouseMoveAt(split, p)
          waitResponse()

          mouseDownAt(split, p)
          waitResponse()

          mouseMoveAt(split, np)
          waitResponse()

          mouseUpAt(split, np)
          waitResponse()

          verifyTrue("the " + comp + " popup must be hidden", !jq(wgtpp).isVisible)
        }
      })

  }
}