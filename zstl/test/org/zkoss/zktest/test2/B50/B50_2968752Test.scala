/* B50_2968752Test.java

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


class B50_2968752Test extends ZTL4ScalaTestCase {
  @Test
  def testChangeIcon() = {
    var zscript =
      """
			<zk>
			    <menubar id="menubar" width="200px">
			        <menu id="menu" label="click me"
							image="/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png">
			            <menupopup>
			                <menuitem id="menuitem"  label="Change"
								onClick='menu.setImage("/img/Centigrade-Widget-Icons/Briefcase-16x16.png")' />
			            </menupopup>
			        </menu>
			    </menubar>
			</zk>
		"""
    runZTL(zscript, () => {
      click(jq("$menu"))
      click(jq("$menuitem"))
      waitResponse()
      verifyEquals("/zktest/img/Centigrade-Widget-Icons/QuestionmarkButton-16x16.png", jq("$menu").toWidget.get("image"))
      verifyEquals("/zktest/img/Centigrade-Widget-Icons/Briefcase-16x16.png", jq("$menu").toWidget.$n("img").get("src"))
    })
  }
}



