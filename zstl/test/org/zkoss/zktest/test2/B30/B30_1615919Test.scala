/* B30_1615919Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1615919Test extends ZTL4ScalaTestCase {
  @Test
  def testDragdrop() = {
    var zscript =
      """
			<zk>
				Click <button id="btn" label="Create" onClick="create2()"/> to open a modal window
				and test if it is draggable.
				<zscript><![CDATA[
				public void create2() {
					final Window win = (Window) Executions.createComponentsDirectly(
					"<window border=\"normal\" closable=\"true\" width=\"300px\" title=\"modal\">"
					+"<listbox><listitem label=\"a1\"/></listbox></window>", null, null, null);
					win.doModal();
				}
				]]></zscript>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      var win = jq("@window")
      var left = win.css("left")
      var top = win.css("top")
      dragdropTo(jq("@window").toWidget().$n("cap"), "10,10", "160,160")
      verifyNotEquals(left, win.css("left"))
      verifyNotEquals(top, win.css("top"))
    })
  }
}



