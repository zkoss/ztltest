package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1076.zul")
class B65_ZK_1076Test extends ZTL4ScalaTestCase {

  def testClick() = {
    runZTL(
      () => {
        var btn = jq("$btn")
        click(btn)
        waitResponse()

        verifyTrue("should see the combobox is shown", jq(".z-tabpanel[style!=none] .z-combobox").exists())

        click(jq("$tab1"))
        waitResponse()
        click(btn)
        waitResponse()

        verifyTrue("should see the combobox is shown", jq(".z-tabpanel[style!=none] .z-combobox").exists())

      })

  }
}
