package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-1959.zul")
class B70_ZK_1959Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<div>
		click the 'add tab' button, and the height of arrow should not
		change
	</div>
	<window title="Tabbox Horizontal with Toolbar"
		sclass="center-bg-win" border="normal" width="300px" height="300px">
		<button label="add tab"
			onClick='tabs.appendChild(new Tab("tab"))'>
		</button>
		<tabbox height="100%">
			<toolbar id="tb">
				<toolbarbutton id="tbb" label="Button 1" />
			</toolbar>
			<tabs id="tabs">
				<tab label="Tab1" closable="true" />
				<tab label="Tab2" closable="true" />
				<tab label="Tab3" />
			</tabs>
			<tabpanels>
				<tabpanel>Tabpanel Content 1</tabpanel>
				<tabpanel>Tabpanel Content 2</tabpanel>
				<tabpanel>Tabpanel Content 3</tabpanel>
			</tabpanels>
		</tabbox>
	</window>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button"))
      waitResponse()
      verifyEquals("the height of arrow should not change", jq(jq(".z-tabbox").toWidget().$n("left")).height(), 33)
    })
    
  }
}