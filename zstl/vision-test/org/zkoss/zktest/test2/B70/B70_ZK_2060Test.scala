package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-2060.zul")
class B70_ZK_2060Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<div>should not see scroll button in inner tabbox</div>
	<tabbox width="300px" height="300px">
		<tabs>
			<tab label="Tab 1" />
			<tab label="Tab 2" />
			<tab label="Tab 3" />
			<tab label="Tab 4" />
			<tab label="Tab 5" />
			<tab label="Tab 6" />
			<tab label="Tab 7" />
		</tabs>
		<tabpanels>
			<tabpanel style="color:#336699;">
				<tabbox width="250px" height="250px">
					<tabs>
						<tab label="Tab 1" />
						<tab label="Tab 2" />
					</tabs>
					<tabpanels>
						<tabpanel style="color:#336699;">
							Panel 1
						</tabpanel>
						<tabpanel style="color:#333399;">
							Panel 2
						</tabpanel>

					</tabpanels>
				</tabbox>
			</tabpanel>
			<tabpanel style="color:#333399;">Panel 2</tabpanel>
			<tabpanel style="color:#663366;">Panel 3</tabpanel>
			<tabpanel style="color:#CC0033;">Panel 4</tabpanel>
			<tabpanel style="color:#CC3300;">Panel 5</tabpanel>
			<tabpanel style="color:#FF9900;">Panel 6</tabpanel>
			<tabpanel style="color:#ABEA14;">Panel 7</tabpanel>
		</tabpanels>
	</tabbox>
</zk>
"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}