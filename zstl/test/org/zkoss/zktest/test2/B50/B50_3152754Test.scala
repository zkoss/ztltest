/* B50_3152754Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_3152754Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
			<li>Click on Show + Invalidate, if Div Content is not shown it is a bug.</li>
			<li>Click on Hide + Invalidate and then Show + Invalidate, if Div Content is not shown it is a bug.</li>
		</ol>
	]]></html>
	<div id="inc" visible="false">
		<window border="normal">
			<label value="Div Content" />
		</window>
	</div>
	<div>
		<button label="Show + Invalidate" onClick='inc.visible = true; inc.invalidate();' />
		<button label="Hide + Invalidate" onClick='inc.visible = false; inc.invalidate();' />
	</div>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val inc = ztl$engine.$f("inc")
    runZTL(zscript, () => {
      verifyFalse(isVisible(jq(inc)))
      click(jq("@button:eq(0)"));
      waitResponse()
      verifyTrue(isVisible(jq(inc)))
      click(jq("@button:eq(1)"));
      waitResponse()
      verifyFalse(isVisible(jq(inc)))
      click(jq("@button:eq(0)"));
      waitResponse()
      verifyTrue(isVisible(jq(inc)))
    })
  }
}



