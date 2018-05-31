package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1662.zul")
class B65_ZK_1662Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
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

        dragdropTo(winC, "10,10", "200,200")
        dragdropTo(winB, "10,10", "200,200")

        val b_Zinx = jq(".z-window-overlapped:contains(B)").css("z-index")
        val c_Zinx = jq(".z-window-overlapped:contains(C)").css("z-index")

        verifyTrue("Window B should be the topmost window.", b_Zinx > c_Zinx)
      })

  }
}