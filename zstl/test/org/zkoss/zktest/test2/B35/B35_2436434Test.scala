/* B35_2436434Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2436434Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
			click add and scroll to right, IE 7 should scroll to the right position.
			  <hbox>
			    <button id="btn" label="add" onClick="add()" />
			    <textbox id="txb" value="this is a tab" width="150px" />
			  </hbox>
			  <tabbox id="tabbox" width="200px">
			    <tabs id="tabs">
			      <tab id="tab1" disabled="true" label="Tab 1" closable="true" />
			      <tab label="Tab 2" closable="true" />
			      <tab label="Tab 3" closable="true" />
			    </tabs>
			    <tabpanels>
			      <tabpanel>This is panel 1</tabpanel>
			      <tabpanel>This is panel 2 The second panel</tabpanel>
			      <tabpanel>This is panel 3</tabpanel>
			    </tabpanels>
			  </tabbox>
			  <zscript><![CDATA[ //@DECLARATION 
			    void add() {
			    Tab tab = new Tab(txb.getValue());
			    tab.setClosable(true);
			    tabs.appendChild(tab);
			    }
			    ]]></zscript>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn = ztl$engine.$f("btn")
    val txb = ztl$engine.$f("txb")
    val tabbox = ztl$engine.$f("tabbox")
    val tabs = ztl$engine.$f("tabs")
    val tab1 = ztl$engine.$f("tab1")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      var x = tabs.attr("scrollLeft").toInt
      click(jq(".z-tabbox").toWidget().$n("right"))
      waitResponse()
      var y = tabs.attr("scrollLeft").toInt
      verifyTrue(x == 0)
      verifyTrue(y > x)
    })
  }
}



