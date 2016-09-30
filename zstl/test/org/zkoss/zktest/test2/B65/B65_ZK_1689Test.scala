package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1689.zul")
class B65_ZK_1689Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<zscript><![CDATA[
		void updateInfo(Window win, Label lLabel, Label tLabel) {
			lLabel.setValue(win.getLeft());
			tLabel.setValue(win.getTop());
		}
	]]></zscript>
	<label multiline="true">
	1. Move the popup window
	2. Minimize/Maximize the popup window.
	3. Click restore button.
	4. If the Left/Top value changed, it is a bug.
	</label>
	<window title="parent win" border="normal">
		<window id="rWin" title="relative win"
			border="normal" mode="popup" position="parent"
			minimizable="true" maximizable="true"
			onCreate="updateInfo(self, lLabel, tLabel);"
			onMove="updateInfo(self, lLabel, tLabel);"
			onMaximize="updateInfo(self, lLabel, tLabel);"
			onMinimize="updateInfo(self, lLabel, tLabel);">
		</window>
		Left: <label id="lLabel" />
		Top: <label id="tLabel" />
    <separator />
		<button label="restore">
			<attribute name="onClick"><![CDATA[
				rWin.setVisible(true);
			]]></attribute>
		</button>
	</window>
</zk>"""
    runZTL(zscript,
      executor = () => {
        val position = "2,2"
        val src = jq("@window.z-window-popup:contains(relative win)").toWidget().$n("cap")
        val target = jq("@window.z-window-embedded:contains(parent win)").toWidget().$n("cap")
        mouseMoveAt(src, position)
        waitResponse()

        mouseDownAt(src, position)
        waitResponse()

        mouseMoveAt(target, position)
        waitResponse()

        mouseUpAt(target, position)
        waitResponse()

        val left = jq(".z-label:contains(px):eq(0)").text()
        val top = jq(".z-label:contains(px):eq(1)").text()
        val max = jq(src).toWidget().$n("max")

        click(max)
        waitResponse()

        click(max)
        waitResponse()

        click(jq(".z-button:contains(restore)"))
        waitResponse()
        
        verifyTrue("the Left/Top value should not change", left == jq(".z-label:contains(px):eq(0)").text() && top == jq(".z-label:contains(px):eq(1)").text())
      })

  }
}