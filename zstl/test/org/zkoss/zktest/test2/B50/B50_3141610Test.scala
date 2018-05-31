/* B50_3141610Test.java

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
import org.zkoss.ztl.Widget


class B50_3141610Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?page title="Bug ID: 3141610" contentType="text/html;charset=UTF-8"?>
<zk>
	<checkbox id="cb" label="Enable Scrollable">
		<attribute name="onCheck"><![CDATA[
	//menubar.scrollable = self.checked;
	menubar.width = self.checked ? "200px" : "100%";
	//menubar.invalidate();
]]></attribute>
	</checkbox>
	<style>
		.z-menubar-horizontal, .z-menubar-vertical { border: 1px solid #D8D8D8; }
	</style>
	<label value="Check the checkbox. The size of menubar will be changed. If you can scroll the resized menubar, it is correct." />
	<menubar id="menubar" width="100%" scrollable="true">
		<menu label="Project">
			<menupopup>
				<menuitem label="New" onClick="alert(self.label)" />
				<menuitem label="Open" onClick="alert(self.label)" />
				<menuitem label="Save" onClick="alert(self.label)" />
				<menuitem label="Exit" onClick="alert(self.label)" />
			</menupopup>
		</menu>
		<menu label="Help">
			<menupopup>
				<menuitem label="Bug Report"
					onClick="alert(self.label)" />
				<menu label="About">
					<menupopup>
						<menuitem label="About Potix"
							onClick="alert(self.label)" />
					</menupopup>
				</menu>
			</menupopup>
		</menu>
		<menu label="this are two color box!!!">
			<menupopup>
				<menu label="Color Picker 1" content="#color=#ff9933" />
				<menu label="Color Picker 2" content="#color=#31548C" />
			</menupopup>
		</menu>
		<menuitem label="ZK Web Framework" onClick="alert(self.label)" />
	</menubar>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb = ztl$engine.$f("cb")
    val menubar = ztl$engine.$f("menubar")
    runZTL(zscript, () => {
      verifyFalse(isVisible(menubar.$n("right")))
      verifyFalse(isVisible(menubar.$n("left")))
      click(cb.$n("real"))
      waitResponse();
      verifyTrue(isVisible(menubar.$n("right")))
      verifyTrue(isVisible(menubar.$n("left")))
    })
  }
}



