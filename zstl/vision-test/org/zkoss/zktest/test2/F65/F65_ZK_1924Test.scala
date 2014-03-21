package org.zkoss.zktest.test2.F65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F65-ZK-1924.zul")
class F65_ZK_1924Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
<div>
Click 'scroll to bottom-right', then you should see red area contains bottomRight text.
Click 'scroll to top-left', then you should see green area contains topLeft text.
</div>
	<div height="200px" width="200px" style="overflow: auto">
		<div height="400px" width="400px">
			<box width="200px" height="200px" id="topLeft" pack="start"
				align="start" style="background-color: green;">
				topLeft
			</box>
			<hbox>
				<div width="200px" height="200px" />
				<box width="200px" height="200px" id="bottomRight"
					pack="end" align="end" style="background-color: red;">
					bottomRight
				</box>
			</hbox>
		</div>
	</div>
	<button label="scroll to bottom-right"
		onClick='Clients.scrollIntoView(bottomRight);' />
	<button label="scroll to top-left"
		onClick='Clients.scrollIntoView(topLeft);' />
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button:contains(bottom)"))
      waitResponse
      verifyImage
      click(jq(".z-button:contains(top)"))
      waitResponse
      verifyImage
    })
    
  }
}