/* B36_2794303Test.java

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
import org.zkoss.ztl.unit.Widget


class B36_2794303Test extends ZTL4ScalaTestCase {
  @Test
  def testicon() = {
    var zscript =
      """
			<zk>
			<panel id="panel" framable="true" width="400px" height="200px"
				maximizable="true" minimizable="true" border="normal"
				collapsible="true" closable="true">
				<caption image="/img/Centigrade-Widget-Icons/FirstWindow-24x24.png" label="You should see the four icon at the right"/>
			</panel>
			</zk>
		"""
    val ztl$engine = engine()
    val panel = ztl$engine.$f("panel")
    runZTL(zscript, () => {
      verifyEquals(4, jq("@panel").find("i").length())
    })
  }
}



