/* B50_3190987Test.java

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


class B50_3190987Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
			<li>Click "add" button.</li>
			<li>The content of the tabbox shall be "new".</li>
			<li>The "old" shall be hided.</li>
		</ol>
	]]></html>
	<button label="add">
		<attribute name="onClick"><![CDATA[
			Tab tab = new Tab("Tab");
			tab.setSelected(true);
			tabs.insertBefore(tab, tabs.getFirstChild());
			Tabpanel panel = new Tabpanel();
			new Label("new").setParent(panel);
			tabpanels.insertBefore(panel, tabpanels.getFirstChild());
		]]></attribute>
	</button>
	<tabbox id="tabbox">
		<tabs id="tabs">
			<tab label="tab" />
		</tabs>
		<tabpanels id="tabpanels">
			<tabpanel>old</tabpanel>
		</tabpanels>
	</tabbox>
</zk>



		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tabbox = ztl$engine.$f("tabbox")
    val tabs = ztl$engine.$f("tabs")
    val tabpanels = ztl$engine.$f("tabpanels")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyEquals("new", jq("@tabpanel:visible").text())
    })
  }
}



