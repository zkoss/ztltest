/* B50_3008291Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3008291Test extends ZTL4ScalaTestCase {
  @Test
  def testFocus() = {
    var zscript =
      """
	<zk>
	<window border="normal" width="200px">
		<button label="Remove" onClick='lbx.removeItemAt(0);' />
		<listbox id="lbx">
			<listhead>
				<listheader label="Label" />
			</listhead>
			<listitem label="3" />
			<listitem label="2" />
			<listitem label="1" />
			<listitem label="-" />
			<listitem label="-" selected="true" focus="true"/>
		</listbox>
	</window>
	</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lbx = ztl$engine.$f("lbx")
    runZTL(zscript, () => {
      var cell = jq("@window @listcell[label=\"-\"]:eq(1)")
      click(cell)
      click(jq("@button"))
      waitResponse()
      click(jq("@button"))
      waitResponse()
      click(jq("@button"))
      waitResponse()
      click(jq("@button"))
      waitResponse()
      verifyEquals(jq(lbx.$n("body")).outerWidth(), jq(lbx.$n("cave")).outerWidth());
    })
  }
}



