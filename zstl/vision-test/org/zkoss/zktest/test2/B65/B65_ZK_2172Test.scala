package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2172.zul")
class B65_ZK_2172Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?page title="ZK Big Listbox Demo for 1 Trillion Data"?>
<zk>
	<window title="Big Listbox Demo for 1 Trillion Data" border="normal"
		apply="org.zkoss.zktest.test2.B65_ZK_2172_Composer" width="100%"
		height="100%">
		<div>
			<div>1. click button</div>
			<div>2. click horizontal scroll right or end button</div>
			<div>3. should see header 'Header x = 19'</div>
			<button label="Set Frozen"
				onClick="myComp.setFrozenCols(3);" />
		</div>
		<vlayout width="100%" vflex="1">
			<biglistbox id="myComp" hflex="1" vflex="1"></biglistbox>
		</vlayout>
	</window>
</zk>
"""  
  runZTL(zscript,
    () => {
      verifyImage()
      click(jq(".z-button"))
      waitResponse()
      verifyImage()
      click(jq(".z-biglistbox-ws-end:eq(1)"))
      waitResponse(true)
      verifyImage()
    })
    
  }
}