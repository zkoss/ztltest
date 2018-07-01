package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2138.zul")
class B65_ZK_2138Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	Open/close groupbox, the div should adjust its size
	<window vflex="1" hflex="1" border="normal">
		<groupbox title="groupbox">
			<div height="100px" width="100px"
				style="border: 1px solid red;" />
		</groupbox>
		<div vflex="1" style="border: 1px solid green">
			div vflex="1"
		</div>
	</window>
	<window vflex="1" hflex="1" border="normal">
		<panel title="panel" collapsible="true" border="normal">
			<panelchildren>
				<div height="75px" width="100px"
					style="border: 1px solid red;" />
			</panelchildren>
		</panel>
		<div vflex="1" style="border: 1px solid green">
			div vflex="1"
		</div>
	</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
      click(jq(".z-groupbox").toWidget().$n("title"))
      waitResponse(true)
      verifyImage()
      click(jq(".z-panel").toWidget().$n("exp"))
      waitResponse(true)
      verifyImage()
      
    })
    
  }
}