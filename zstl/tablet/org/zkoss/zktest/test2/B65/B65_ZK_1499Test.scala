package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "Touch,Android")
class B65_ZK_1499Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	iPad/Android only
	
	1. click collapse/extend, maximize/minimize button for each panel/window.
	
	All of the buttons on title bar must show correct image.
	
	</label>
	<separator />
	<hlayout>
		<div>
			<panel title="Title" border="normal" width="300px" height="100px"
				closable="true" collapsible="true" maximizable="true" minimizable="true">
				<panelchildren />
			</panel>
			<panel title="Title and Caption" border="normal" width="300px" height="100px"
				closable="true" collapsible="true" maximizable="true" minimizable="true">
				<caption />
				<panelchildren />
			</panel>
			<panel title="Caption" border="normal" width="300px" height="200px"
				closable="true" collapsible="true" maximizable="true" minimizable="true">
				<caption />
				<panelchildren />
			</panel>
		</div>
		<div>
			<window title="Title" border="normal" width="300px" height="100px" 
				closable="true" maximizable="true" minimizable="true" />
			<window title="Title and Caption" border="normal" width="300px" height="100px" 
				closable="true" maximizable="true" minimizable="true">
				<caption />
			</window>
			<window title="Caption" border="normal" width="300px" height="100px" 
				closable="true" maximizable="true" minimizable="true">
				<caption />
			</window>
		</div>
	</hlayout>
</zk>
    """

    runZTL(zscript,
      () => {

        List(".z-panel", ".z-window-embedded") foreach { containerClass =>
          0 to 2 foreach { i =>
            if (containerClass == ".z-panel") {
              val exp = jq(jq(".z-panel:eq(" + i + ")").toWidget().$n("exp"))
              val expcls = exp.find("i").attr("class")
              singleTap(exp)
              waitResponse()
              verifyTrue("show correct image.", exp.find("i").attr("class") != expcls)
            }
            val max = jq(jq(containerClass + ":eq(" + i + ") ").toWidget().$n("max"))
            val maxcls = max.find("i").attr("class")
            singleTap(max)
            waitResponse()
            verifyTrue("show correct image.", max.find("i").attr("class") != maxcls)
            singleTap(max)
            waitResponse()
          }
        }

      })

  }
}
