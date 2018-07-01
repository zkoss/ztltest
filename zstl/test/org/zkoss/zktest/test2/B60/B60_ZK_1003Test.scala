package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B60-ZK-1003.zul")
class B60_ZK_1003Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
                    <div>You should see two Toolbar below the 'Panel Content'</div>
                    <div height="400px" style="border: 1px solid red">
                      <panel vflex="1" border="normal" title="Panel" framable="true" closable="true" maximizable="true" minimizable="true" collapsible="true">
                        <toolbar mold="panel">Toolbar</toolbar>
                        <panelchildren>
                          Panel Content
                        </panelchildren>
                        <toolbar>Toolbar</toolbar>
                        <toolbar mold="panel">Toolbar</toolbar>
                      </panel>
                    </div>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyEquals("should see two Toolbar below the 'Panel Content'", jq(".z-panel .z-toolbar-panel").length(), 2)
      })

  }
}
