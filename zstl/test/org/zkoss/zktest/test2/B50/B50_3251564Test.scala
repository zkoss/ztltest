/* B50_3251564Test.java

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


class B50_3251564Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Click on the Textbox on the right side and click somewhere else to show the Errorbox.</li>
			<li>The Errorbox should appear within the browser screen (so you shoule be able to see it).</li>
			<li>The Errorbox should NOT cover the Textbox.</li>
		</ol>
	]]></html>
	<style>
		body {
			overflow: hidden;
		}
	</style>
	<window border="normal">
		<hlayout>
			<div hflex="1" />
			<textbox constraint="no empty" />
		</hlayout>
	</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      var x = jq("@textbox").positionLeft()
      typeKeys(jq("@textbox"), "")
      waitResponse(true)
      verifyTrue(jq(".z-errorbox").exists())
      var y = jq(".z-errorbox").positionLeft()
      var y1 = jq(".z-errorbox").width()
      verifyTrue(x > y)
      verifyTolerant(x - y1, y, 1)
    })
  }
}



