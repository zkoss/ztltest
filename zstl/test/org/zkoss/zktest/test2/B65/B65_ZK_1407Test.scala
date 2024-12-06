
package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.{NonConcurrent, Tags}

@Tags(tags = "B65-ZK-1407.zul")
@NonConcurrent
class B65_ZK_1407Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        // 1. Combobox's initial background color is yellow.
        val inp = jq(jq(".z-combobox").toWidget().$n("real"))
        val initColor = inp.css("background-color")
        val isYellow = initColor == "yellow" || initColor == "rgb(255, 255, 0)"
        verifyTrue("Combobox's initial background color is yellow", isYellow)

        // 2. Click button to open dorp-down list, and Combobox's background color will transform to green.
        click(jq(jq(".z-combobox").toWidget().$n("btn")))
        waitResponse()
        val afterClickColor = inp.css("background-color")
        val isGreen = afterClickColor == "green" || afterClickColor == "rgb(0, 128, 0)"
        verifyTrue("Combobox's initial background color is green", isGreen)

        // 3. Select a item, and then Combobox's background color must be still green.
        click(jq("@comboitem:eq(0)"))
        waitResponse()
        val selectColor = inp.css("background-color")
        val isGreenAgain = selectColor == "green" || selectColor == "rgb(0, 128, 0)"
        verifyTrue("Combobox's initial background color is green", isGreenAgain)

      })

  }
}