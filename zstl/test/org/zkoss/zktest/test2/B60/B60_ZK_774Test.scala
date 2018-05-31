package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B60-ZK-774.zul")
class B60_ZK_774Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
                    <div>
                      There should be no gap between the bottom red border the bottom green border.
                    </div>
                    <window title="Panel toolbar" border="normal" width="400px" height="400px">
                      <panel hflex="1" vflex="1" style="border: 1px solid #009900">
                        <panelchildren>
                          Panelchildren Content
                        </panelchildren>
                        <toolbar mold="panel" align="end" style="border: 1px solid #990000">
                          <button label="OK"/>
                        </toolbar>
                      </panel>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        val bodyHeight = jq(".z-panel-body").height()
        val panelchildrenHeight = jq(".z-panelchildren").outerHeight(false)
        val panelHeight = jq(".z-panel-bottom").height()
        verifyEquals(bodyHeight, panelchildrenHeight + panelHeight)
      })

  }
}
