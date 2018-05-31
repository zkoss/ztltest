/* B36_2806448Test.java

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
import org.zkoss.ztl.Widget


class B36_2806448Test extends ZTL4ScalaTestCase {
  @Test
  def testclear() = {
    var zscript =
      """
			<zk>
			Right-click on the 'female' item to show a menu popup and left-click on
			the 'Mary' item, and then all the listbox should be removed, especially
			menupopup's shadow.
			<separator/>
			<div id="outer">
			<listbox width="250px" context="popup">
			<listhead sizable="true">
			<listheader label="Name"/>
			<listheader label="Gender"/>
			</listhead>
			<listitem onClick="outer.detach();">
			<listcell label="Mary"/>
			<listcell label="female"/>
			</listitem>
			</listbox>
			<menupopup id="popup">
			<menuitem label="Index" onClick="alert(self.label)"/>
			</menupopup>
			</div>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val outer = ztl$engine.$f("outer")
    val popup = ztl$engine.$f("popup")
    runZTL(zscript, () => {
      var cell = jq("@listcell[label=\"female\"]")
      contextMenu(cell)
      waitResponse()
      verifyTrue(jq("@menupopup").exists())
      click(jq("@listcell[label=\"Mary\"]"))
      waitResponse()
      verifyFalse(jq("@menupopup").exists())
    })
  }
}



