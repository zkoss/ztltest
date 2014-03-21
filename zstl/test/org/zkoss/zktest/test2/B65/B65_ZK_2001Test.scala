package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2001.zul")
class B65_ZK_2001Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<div>click chosenbox, then the listitem should not be selected</div>
	<listbox width="500px">
		<listhead>
			<listheader label="col" />
			<listheader label="col" />
			<listheader label="col" />
		</listhead>
		<listitem forEach="1,2">
			<listcell label="Item ${each}" />
			<listcell>
				<textbox />
			</listcell>
			<listcell>
				<chosenbox width="100px" />
			</listcell>
		</listitem>
	</listbox>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-chosenbox"))
      waitResponse()
      
      verifyTrue("the listitem should not be selected", !jq(".z-listitem-seld").exists)
    })
    
  }
}