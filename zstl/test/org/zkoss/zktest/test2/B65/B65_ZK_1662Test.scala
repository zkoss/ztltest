package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.JQuery
import org.zkoss.ztl.Element

@Tags(tags = "B65-ZK-1662.zul")
class B65_ZK_1662Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	1. Move Window C to center.
	2. Overlap Window B on Window C partially.
	Expected: Window B should be the topmost window.
	</label>
	<window sizable="true" mode="overlapped" border="normal" title="Window A" closable="true">
		<label value="Hello World"/>
	</window>
	<window sizable="true" mode="overlapped" border="normal" title="Window B" closable="true">
		<label value="Hello World"/>
	</window>
	<window sizable="true" mode="overlapped" border="normal" title="Window C" closable="true">
		<label value="Hello World"/>
	</window>
</zk>
"""
    runZTL(zscript,
      () => {
        val winC = jq(".z-window-overlapped:contains(C)").toWidget().$n("cap")
        val winB = jq(".z-window-overlapped:contains(B)").toWidget().$n("cap")

        val dragDrop = (comp: Element, posi: String, newPosi: String) => {
          mouseMoveAt(comp, posi)
          waitResponse

          mouseDownAt(comp, posi)
          waitResponse

          mouseMoveAt(comp, newPosi)
          waitResponse

          mouseUpAt(comp, newPosi)
          waitResponse
        }
        dragDrop(winC, "10,10", "200,200")
        dragDrop(winB, "10,10", "200,200")
        
        val b_Zinx = jq(".z-window-overlapped:contains(B)").css("z-index")
        val c_Zinx = jq(".z-window-overlapped:contains(C)").css("z-index")

        verifyTrue("Window B should be the topmost window.", b_Zinx > c_Zinx)
      })

  }
}