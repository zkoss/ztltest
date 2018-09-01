/* B35_2080349Test.java

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


class B35_2080349Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window>
	Clicks the following button, then a menu shall be popped up.
	<separator/>
	<button label="popup" popup="editPopup"/>
	<menupopup id="editPopup">
        <menuitem label="Undo"/>
        <menuitem label="Redo"/>
        <menu label="Sort">
			<menupopup>
		        <menuitem label="Sort by Name" autocheck="true"/>
		        <menuitem label="Sort by Date" autocheck="true"/>
			</menupopup>
        </menu>
	</menupopup>
</window>

		"""
    val ztl$engine = engine()
    val editPopup = ztl$engine.$f("editPopup")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyTrue(jq(".z-menupopup").exists())
    })
  }
}



