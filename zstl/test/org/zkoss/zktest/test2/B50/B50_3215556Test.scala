/* B50_3215556Test.java

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


class B50_3215556Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
	       <ol>
	       		<li>IE only</li>
	      	 	<li>Click maximal icon of the panel.</li>
				<li>Click close icon of the panel.</li>
				<li>It shall not js error happen.</li>
			</ol>
	]]></html>
	<portallayout maximizedMode="whole">
		<portalchildren>
			<panel maximizable="true" closable="true">
				<caption>aaa</caption>
				<panelchildren>
				</panelchildren>
			</panel>
		</portalchildren>
	</portallayout>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq(".z-panel").toWidget().$n("max"))
      waitResponse()
      click(jq(".z-panel").toWidget().$n("close"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



