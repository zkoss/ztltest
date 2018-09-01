/* B50_3190542Test.java

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


class B50_3190542Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
			<li>Click Maximize icon. the panel will become lagger.</li>
			<li>Click restore icon. that shall not error happen.</li>
		</ol>
	]]></html>
	<portallayout id="pl" maximizedMode="whole">
		<portalchildren >
			<panel height="150px" title="panel" border="normal" 
				maximizable="true" onMaximize="">
				<panelchildren>
				</panelchildren>
			</panel>
		</portalchildren>
	</portallayout>
</zk>

		"""
    val ztl$engine = engine()
    val pl = ztl$engine.$f("pl")
    runZTL(zscript, () => {
      var pll = pl.$n()
      var screenwidth = jq(pll.parentNode()).width()
      var x = jq("@panel").width()
      click(jq(".z-panel-icon"))
      waitResponse()
      var x1 = jq("@panel").width()
      verifyTrue(x1 > x)
      verifyTrue(screenwidth < x1 + 10)
      click(jq(".z-panel-icon"))
      waitResponse()
      verifyFalse(jq("@window").exists())
    })
  }
}



