package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-2087.zul")
class F70_ZK_2087Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<window apply="org.zkoss.zktest.test2.F70_ZK_2087">
	<label multiline="true">
		1. Click the button.
		2. Should see a messagebox with red border.
	</label>
	<button label="Click" id="btn"/>
	<style>
	.myMessagebox {
		border-color: red;
	}
	</style>
</window>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button"))
      waitResponse()
      verifyImage()
    })
    
  }
}