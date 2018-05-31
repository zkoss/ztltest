package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1679.zul")
class B65_ZK_1679Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">
		1. Resize the window
		2. If you see green background bar expand to window size, it is a bug.
	</label>
	<window sizable="true" mode="overlapped" title="win-div" border="normal" closable="true">
		<vlayout>
			<hlayout vflex="1" hflex="min" style="background:green">
				<div style="background:yellow">
					<image src="/img/msn2.gif" width="50px" height="50px" />
				</div>
				<div style="background:cyan">
					<image src="/img/msn2.gif" width="50px" height="50px" />
				</div>
			</hlayout>
		</vlayout>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        dragdropTo(jq(".z-window-overlapped"), "2, 2", "0,320")
        waitResponse()
        verifyTrue("you should not see green background bar expand to window size", (jq(".z-hlayout").height() - 50).abs < 5)
        verifyTrue("you should not see green background bar expand to window size", (jq(".z-hlayout").width() - 105).abs < 5)
      })

  }
}