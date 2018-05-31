package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1349.zul")
class B65_ZK_1349Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <label multiline="true">
                      1. Click "show" button.
    				  2. Should see a blue background cell.
                    </label>
                    <grid width="60ex">
                      <columns>
                        <column label="Arabic numeral"/>
                        <column id="col2" label="Capital letter" visible="false"/>
                        <column label="Roman numeral"/>
                      </columns>
                      <rows>
                        <row>
                          <cell>
                            <label value="1"/>
                          </cell>
                          <cell style="white-space: nowrap; background-color: cyan;">
                            <label value="A"/>
                          </cell>
                          <cell>
                            <label value="I"/>
                          </cell>
                        </row>
                      </rows>
                    </grid>
                    <button label="show" onClick="col2.setVisible(true)"/>
                  </zk>
"""
    runZTL(zscript,
      () => {
        click(jq("@button"))
        waitResponse()
        val color = jq(".z-cell:contains(A)").css("background-color")
        val isCyan = color == "cyan" || color == "rgb(0, 255, 255)"
        verifyTrue("Should see a blue background cell.", isCyan)
      })

  }
}
