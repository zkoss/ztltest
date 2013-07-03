package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1500.zul")
class B65_ZK_1500Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <zscript><![CDATA[
	void onMaximize(Component comp) {
		if (comp.isMaximized()) {
			comp.setClosable(false);
		} else {
			comp.setClosable(true);
		}
	}
	]]></zscript>
                    <label multiline="true">
                      1. Click panel's maximize icon to maximize.
	2. Click panel's restore icon, the size should the same before maximized.
	Also test on Window.
                    </label>
                    <panel title="panel" border="normal" width="300px" height="200px" minimizable="true" collapsible="true" closable="true" maximizable="true" onMaximize="onMaximize(self)">
                      <panelchildren></panelchildren>
                    </panel>
                    <window title="window" border="normal" width="300px" height="200px" minimizable="true" closable="true" maximizable="true" onMaximize="onMaximize(self)" maximized="true">
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        val panel = jq("@panel")
        val panelWidth = panel.width()
        val panelHeight = panel.height()
        val pnlwgt = panel.toWidget()

        click(pnlwgt.$n("max"))
        waitResponse()
        click(pnlwgt.$n("maxd"))
        waitResponse()
        verifyEquals("the width should the same before maximized", panel.width(), panelWidth)
        verifyEquals("the height should the same before maximized", panel.height(), panelHeight)
        
        val window = jq("@window")
        val windowWidth = window.width()
        val windowHeight = window.height()
        val wndwgt = window.toWidget()

        click(wndwgt.$n("maxd"))
        waitResponse()
        click(wndwgt.$n("max"))
        waitResponse()
        verifyEquals("the width should the same before maximized", window.width(), windowWidth)
        verifyEquals("the height should the same before maximized", window.height(), windowHeight)
      })

  }
}
