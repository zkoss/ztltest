package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-2231.zul")
class B65_ZK_2231Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">
		Click "Upload" button, should not see any JS error.
	</label>
	<vbox hflex="1">
		<button label="Upload" onClick="vbox1.setVisible(true);" />
		<vbox hflex="1" id="vbox1" visible="false"></vbox>
		<window title="window" visible="false" border="normal">
			Window
		</window>
	</vbox>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button"))
        waitResponse()
        verifyFalse("should see no javascript error", jq(".z-error").exists())
      })

  }
}