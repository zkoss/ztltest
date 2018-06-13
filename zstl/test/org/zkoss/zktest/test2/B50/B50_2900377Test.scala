/* B50_2900377Test.java

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


class B50_2900377Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
				You should see the panel is closed.
				<panel id="panel" title="Panel" border="normal" collapsible="true" open="false">
				<panelchildren>
				<label>test</label>
				</panelchildren>
				</panel>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val panel = ztl$engine.$f("panel")
    runZTL(zscript, () => {
      verifyEquals("none", jq(jq(".z-panel").toWidget().$n("body")).css("display"));
    })
  }
}



