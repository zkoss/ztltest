/* B30_2562880Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_2562880Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
			1. Please click on "11111111", then the menupopup appears.
			<separator/>
			2. Please click on the arrow of the "A" header, then the menupopup should be closed.
			<listbox width="150px">
			<listhead sizable="true">
				<listheader id="lh" label="A" sort="auto"/>
			</listhead>
				<listitem popup="popup" label="111111111"/>
			</listbox>
			<menupopup id="popup">
				<menuitem label="test"/>
				<menuitem label="test"/>
				<menuitem label="test"/>
			</menupopup>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lh = ztl$engine.$f("lh")
    val popup = ztl$engine.$f("popup")
    runZTL(zscript, () => {
      click(jq(".z-listcell"))
      waitResponse()
      verifyTrue(isVisible(popup))
      clickAt(lh.$n("cave"), "2,2")
      waitResponse()
      verifyTrue(!popup.exists() || !isVisible(popup))
    })
  }
}



