package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B60-ZK-1784.zul")
class B60_ZK_1784Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk xmlns:n="native">
	Click the button, no JS should appear: tabbox will be invalidated, the component nested in native element in Tab1 should not cause a problem
	<tabbox id="tabbox" apply="org.zkoss.zktest.test2.B60_ZK_1784_Composer">
		<tabs id="tabs">
			<tab id="tab1" label="Tab 1" />
			<tab id="tab2" label="Tab 2" selected="true" />
		</tabs>
		<tabpanels id="tabpanels">
			<tabpanel>
				<n:div>
					<div hflex="0">
						Test inside native
					</div>
				</n:div>
			</tabpanel>
			<tabpanel>
				<button id="button" label="click me">
				</button>
			</tabpanel>
		</tabpanels>
	</tabbox>
</zk>
"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button"))
      waitResponse()
      
      verifyFalse("should see no javascript error", jq(".z-error").exists())
      
      click(jq(".z-tab:contains(1)"))
      waitResponse()
      
      verifyFalse("should see no javascript error", jq(".z-error").exists())
    })
    
  }
}