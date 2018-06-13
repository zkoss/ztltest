/* B50_2903271Test.java

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


class B50_2903271Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<?page title="teste"?>
<zk>
<zscript>
void close(tabClose, tabSelect) {
	tabClose.close();
	tabSelect.setSelected(true);
}
</zscript>
<tabbox id="tabbox">
	<tabs>
	<tab label="Tab 1" closable="true" id="tab1" />
	<tab label="Tab 2" closable="true" id="tab2" />
	<tab label="Tab 3" closable="true" id="tab3" />
	<tab label="Tab 4" closable="true" id="tab4" />
	<tab label="Tab 5" closable="true" id="tab5"/>
	</tabs>
	<tabpanels>
	<tabpanel>
Click <button label="close 1 and select 5" onClick="close(tab1, tab5)"/>
and then tab 5 will be selected
<separator/>
<button label="select 3" onClick="tab3.setSelected(true)"/>
<button label="change mold" onClick='tabbox.mold = "default".equals(tabbox.mold) ? "accordion":"default"'/>
	</tabpanel>
	<tabpanel>This is panel 2</tabpanel>
	<tabpanel>This is panel 3</tabpanel>
	<tabpanel>This is panel 4</tabpanel>
	<tabpanel>This is panel 5
Click <button label="close 5 and select 2" onClick="close(tab5, tab2)"/>
and tab2 will be selected
	</tabpanel>
	</tabpanels>
</tabbox>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tabbox = ztl$engine.$f("tabbox")
    val tab1 = ztl$engine.$f("tab1")
    val tab2 = ztl$engine.$f("tab2")
    val tab3 = ztl$engine.$f("tab3")
    val tab4 = ztl$engine.$f("tab4")
    val tab5 = ztl$engine.$f("tab5")
    runZTL(zscript, () => {
      click(jq("@button[label=\"close 1 and select 5\"]"))
      waitResponse()
      verifyTrue(jq("$tab5").hasClass("z-tab-selected"))
      click(jq("@button"))
      waitResponse()
      verifyTrue(jq("$tab2").hasClass("z-tab-selected"))
    })
  }
}



