package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1803.zul")
class B65_ZK_1803Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<div id="div">
		<label>Press enter in the textbox should not see any JS error </label>
		<separator />
		<textbox value="Jerry" width="150px" id="test" onOK="test.visible=false; div.invalidate();"/>
	</div>
</zk>"""
    runZTL(zscript,
      () => {
        sendKeys(jq(".z-textbox"), Keys.ENTER)
        waitResponse()
        verifyFalse("should see no javascript error", jq(".z-error").exists())
      })

  }
}