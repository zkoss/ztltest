/* B50_2931212Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2931212Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<tabbox  id="tabs">
    <tabs>
        <tab label="Close Me, you should see aa, rather than bb" closable="true" id="aa" onClose='alert(tabs.getSelectedTab().getId())'/>
        <tab label="Tab 2" closable="true" id="bb"/>
        <tab label="Tab 3" closable="true"/>
        <tab label="Tab 4" closable="true"/>
        <tab label="Tab 5" closable="true"/>
    </tabs>
    <tabpanels>
        <tabpanel>
            This is panel 1
        </tabpanel>
        <tabpanel>
            This is panel 2
		The second panel
        </tabpanel>
        <tabpanel>
            This is panel 3
        </tabpanel>
        <tabpanel>
            This is panel 4
        </tabpanel>
        <tabpanel>
            This is panel 5
        </tabpanel>
    </tabpanels>
</tabbox>

			"""
    val ztl$engine = engine()
    val tabs = ztl$engine.$f("tabs")
    val aa = ztl$engine.$f("aa")
    val bb = ztl$engine.$f("bb")
    runZTL(zscript, () => {
      click(aa.$n("cls"))
      waitResponse()
      verifyEquals("aa", jq(".z-messagebox-window .z-label").html())
    })
  }
}



