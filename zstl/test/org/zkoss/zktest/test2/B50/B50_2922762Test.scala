/* B50_2922762Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2922762Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					The tabbox below doesn't show tabscroll.(Doesn't have left and right arrow button on the tabbox is correct )
					<separator height="30px"/>
					<tabbox width="150px" tabscroll="false">
						<tabs>
							<tab id="tab1" label="Tab 1" closable="true"/>
							<tab label="Tab 2" closable="true"/>
							<tab label="Tab 3" closable="true"/>
							<tab label="Tab 4" closable="true"/>
							<tab label="Tab 5" closable="true"/>
						</tabs>
						<tabpanels id="tabpnl">
							<tabpanel>This is panel 1</tabpanel>
							<tabpanel>This is panel 2</tabpanel>
							<tabpanel>This is panel 3</tabpanel>
							<tabpanel>This is panel 4</tabpanel>
							<tabpanel>This is panel 5</tabpanel>
						</tabpanels>
					</tabbox>
				</zk>
			"""
    val ztl$engine = engine()
    val tab1 = ztl$engine.$f("tab1")
    val tabpnl = ztl$engine.$f("tabpnl")
    runZTL(zscript, () => {
      verifyFalse(jq(".z-tabs-left-scroll").exists())
      verifyFalse(jq(".z-tabs-right-scroll").exists())
    })
  }
}



