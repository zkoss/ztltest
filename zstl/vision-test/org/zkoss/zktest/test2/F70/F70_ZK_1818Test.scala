package org.zkoss.zktest.test2.F70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "F70-ZK-1818.zul")
class F70_ZK_1818Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	You should see tabs on the bottom in first tabbox,
	and tabs on the	right in second tabbox.
	<tabbox height="300px" width="400px" orient="bottom">
		<tabs>
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
	<tabbox height="300px" width="400px" orient="right">
		<tabs width="80px">
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
</zk>"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}