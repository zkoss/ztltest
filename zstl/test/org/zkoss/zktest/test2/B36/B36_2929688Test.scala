/* B36_2929688Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2929688Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window>
	<tabbox mold="accordion-lite">
	<tabs>
		<tab id="tab1" label="Tab 1"/>
		<tab id="tab2" label="Tab 2"/>
	</tabs>
	<tabpanels>
		<tabpanel>
		<label value="Test"/>
		</tabpanel>
		<tabpanel>
		<textbox id="tb" constraint="no empty"/> 
		</tabpanel> 
	</tabpanels> 
	</tabbox> 
	<button label="Check Me, then you should see a WrongValue exception!" onClick="click()"/> 
	<zscript> void click() { 
		try{ tb.getValue(); }
		catch(WrongValueException e)
		{ tab2.setSelected(true); throw e; } }
	</zscript> 
</window>


		"""
    val ztl$engine = engine()
    val tab1 = ztl$engine.$f("tab1")
    val tab2 = ztl$engine.$f("tab2")
    val tb = ztl$engine.$f("tb")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



