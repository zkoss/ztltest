package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-1826.zul")
class B70_ZK_1826Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<div>
		Resize the window and then click the button, the width and height should
		not change.
	</div>
	<window id="win" title="orig" border="normal" mode="overlapped"
		sizable="true" width="200px">
		<button style="float:right" label="set title to ZK" onClick='win.setTitle("ZK");' />
	</window>
</zk>
"""
    runZTL(zscript,
      () => {

        val position = "2,2"
        val src = jq(".z-window")
        dragdropTo(src, position, "2,4")
        waitResponse()

        val h = src.height()
        val w = src.width()

        click(jq(".z-button"))
        waitResponse()

        verifyTrue("the width and height should not change.", src.height() == h && src.width() == w)
      })

  }
}