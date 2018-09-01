/* B50_3036584Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3036584Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk>
<html><![CDATA[
<ol>
 <li>Move mouse over one of the menu below (don't click)</li>
 <li>If the popup remains (no closed), it is correct</li>
 <li>Then, click the menu item and the popup shall be closed</li>
</ol>
]]></html>
<window title="new page title" border="normal">
	<menubar>
		<menuitem label="Test" />
		<menu label="Project" image="/img/Centigrade-Widget-Icons/Briefcase-16x16.png">
			<menupopup>
				<menuitem image="/img/Centigrade-Widget-Icons/BriefcaseSpark-16x16.png" label="New"
					onClick="alert(self.label)" />
				<menuitem image="/img/Centigrade-Widget-Icons/BriefcaseOpen-16x16.png" label="Open"
					onClick="alert(self.label)" />
				<menuitem image="/img/Centigrade-Widget-Icons/DisketteBlack-16x16.png" label="Save"
					onClick="alert(self.label)" />
				<menuseparator />
				<menuitem label="Exit" image="/img/Centigrade-Widget-Icons/DoorOpen-16x16.png" onClick="alert(self.label)" />
			</menupopup>
		</menu>
	</menubar>
	<window title="Test" mode="popup" border="normal">
		Test...
	</window>
</window>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      mouseOver(jq(".z-menu > a"))
      waitResponse()
      verifyTrue(isVisible(jq("@window[title=\"Test\"]")))
      clickAt(jq(".z-menuitem"), "6,6")
      waitResponse()
      verifyFalse(isVisible(jq("@window[title=\"Test\"]")))
    })
  }
}



