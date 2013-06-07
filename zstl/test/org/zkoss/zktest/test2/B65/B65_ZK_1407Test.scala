
package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1407.zul")
class B65_ZK_1407Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <style>
                      .buggy .z-combobox-inp{
                        background-color: yellow;
                      }
                      .buggy.z-combobox.z-combobox-focus .z-combobox-inp{
                        background-color: green;
                      }
                    </style>
                    <label multiline="true">
                      1. Combobox's initial background color is yellow.
	2. Click button to open dorp-down list, and Combobox's background color will transform to green.
	3. Select a item, and then Combobox's background color must be still green.
                    </label>
                    <combobox sclass="buggy">
                      <comboitem label="item 1"></comboitem>
                      <comboitem label="item 2"></comboitem>
                    </combobox>
                  </zk>"""

    runZTL(zscript,
      () => {
        // 1. Combobox's initial background color is yellow.
        val inp = jq(".z-combobox-input")
        val initColor = inp.css("background-color")
        val isYellow = initColor == "yellow" || initColor == "rgb(255, 255, 0)"
        verifyTrue("Combobox's initial background color is yellow", isYellow)

        // 2. Click button to open dorp-down list, and Combobox's background color will transform to green.
        click(jq(".z-combobox-icon"))
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