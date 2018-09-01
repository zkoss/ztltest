package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B70_ZK_2003Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    runZTL(
      () => {
        val split = jq(".z-north").toWidget.$n("split")
        var list = List("combobox", "bandbox")
        for (comp <- list) {
          val wgt = jq(".z-" + comp).toWidget
          val wgtpp = wgt.$n("pp")
          click(wgt.$n("btn"))
          waitResponse()
          verifyTrue("the " + comp + " popup will show up", jq(wgtpp).isVisible)
          val p = "2,2"
          val np = "2,4"
          dragdropTo(split, p , np)
          waitResponse()

          verifyFalse("the " + comp + " popup must be hidden", jq(wgtpp).isVisible)
        }
      })

  }
}