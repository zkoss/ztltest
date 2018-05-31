package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1187.zul")
class B65_ZK_1187Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
1. Please click the button, and then the style of the tab is the same as selected.
<button  label="Click Me" onClick='tab.sclass="def"'/>
	<tabbox width="250px">
		<tabs>
			<tab id="tab" label="Tab 1" sclass="abc" closable="true"/>
		</tabs>
		<tabpanels>
			<tabpanel>This is panel 1</tabpanel>
		</tabpanels>
	</tabbox>
</zk>
    """;

    runZTL(zscript,
      () => {
        click(jq("@button:eq(0)"))
        waitResponse()
        verifyTrue("the style of the tab is the same as selected", jq("@tab.def").exists())
      })

  }
}