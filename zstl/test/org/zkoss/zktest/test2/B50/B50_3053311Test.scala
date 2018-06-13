/* B50_3053311Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3053311Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk>
	<label multiline="true">
		<attribute name="value">
			1. Open the menubar, and see the color in the menu item
			2. Click "Vertical orient" to change menubar's orient
			3. Open the menubar again, the color shoule be the same, if it change to black, it'is wrong.
		</attribute>
	</label>
	<menubar id="menubar" width="100%">
		<menu image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
			<menupopup>
				<menu label="Color Picker" content="#color=#184dc6" />
			</menupopup>
		</menu>
	</menubar>
	<checkbox id="chgOrient" label="Vertical orient">
		<attribute name="onCheck">
			menubar.orient = self.checked ? "vertical" : "horizontal";
		</attribute>
	</checkbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val menubar = ztl$engine.$f("menubar")
    val chgOrient = ztl$engine.$f("chgOrient")
    runZTL(zscript, () => {
      var menu = jq(".z-menu")
      click(menu)
      waitResponse()
      var img = menu.toWidget().$n()
      var color1 = jq(img).css("backgroundColor")
      clickAt(jq("@label:eq(0)"), "6,6"); //to blur
      waitResponse()
      click(chgOrient.$n("real"))
      waitResponse()
      click(menu)
      waitResponse()
      var color2 = jq(img).css("backgroundColor")
      verifyEquals(color1, color2)
    })
  }
}



