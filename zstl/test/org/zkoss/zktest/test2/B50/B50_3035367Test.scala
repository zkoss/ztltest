/* B50_3035367Test.java

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


class B50_3035367Test extends ZTL4ScalaTestCase {
  @Test
  def testROD() = {
    var zscript =
      """
<window title="Test Case: Updating list model of not yet rendered listbox" border="normal" width="500px" height="400px">
<tabbox height="100%" >
<tabs>
<tab id="t1" label="Visible (selected) Tab" selected="true"></tab>
<tab id="t2" label="Not visible (selected) by default" selected="false"></tab>
<tab id="t3" label="Not visible (selected) by default" selected="false"></tab>
</tabs>
<tabpanels>
<tabpanel>
<button label="update list model of listbox on second tab panel" onClick='listbox1.setModel(new ListModelList(Collections.singletonList("element")));' />
<button label="update list model of grid on third tab panel" onClick='grid1.setModel(new ListModelList(Collections.singletonList("element")));' />
</tabpanel>
<tabpanel>
<listbox id="listbox1" vflex="true" > <!-- if height="100%" or vflex="true": script error if button is pressed -->
<listhead>
<listheader label="Listbox" />
</listhead>
</listbox>
</tabpanel>
<tabpanel>
<grid id="grid1" vflex="true" > <!-- if height="100%" or vflex="true": script error if button is pressed -->
<columns>
<column label="Grid" />
</columns>
<rows/>
</grid>
</tabpanel>
</tabpanels>
</tabbox>
</window>		
"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val t1 = ztl$engine.$f("t1")
    val t2 = ztl$engine.$f("t2")
    val t3 = ztl$engine.$f("t3")
    val listbox1 = ztl$engine.$f("listbox1")
    val grid1 = ztl$engine.$f("grid1")
    runZTL(zscript, () => {
      click(jq("@button[label=\"update list model of listbox on second tab panel\"]"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      click(jq(t2))
      waitResponse()
      verifyEquals("Listbox", getText(jq("@listheader")))
      verifyEquals("element", getText(jq("@listcell")))
      click(jq(".z-tabbox-left-scroll").get(0))
      waitResponse()
      click(jq(t1))
      waitResponse()
      click(jq("@button:contains(grid)"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      click(jq(".z-tabbox-right-scroll").get(0))
      waitResponse()
      click(jq(".z-tabbox-right-scroll").get(0))
      waitResponse()
      click(jq(t3))
      waitResponse()
      verifyEquals("Grid", getText(jq("@column")))
      verifyEquals("element", getText(jq("@label")))
    })
  }
}



