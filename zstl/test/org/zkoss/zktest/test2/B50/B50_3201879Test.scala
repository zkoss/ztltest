/* B50_3201879Test.java

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


class B50_3201879Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<popup id="pop">
		<button label="Click me if you cannot see a dialog, that is a bug!" onClick="alert(&quot;yes! The bug is fixed!&quot;)"/>
	</popup>
	<window border="none" height="100%">
		<window id="win" visible="false" position="center">
			<button label="click again" onClick="pop.open(self)"/>
		</window>
		<button label="Click Me first." onClick="win.doModal()"/>
	</window>
</zk>

		"""
    val ztl$engine = engine()
    val pop = ztl$engine.$f("pop")
    val win = ztl$engine.$f("win")
    runZTL(zscript, () => {
      click(jq("@button[label=\"Click Me first.\"]"))
      waitResponse()
      click(jq("@button[label=\"click again\"]"))
      waitResponse()
      click(jq("@button[label=\"Click me if you cannot see a dialog, that is a bug!\"]"))
      waitResponse()
      verifyEquals("yes! The bug is fixed!", getAlertMessage())
    })
  }
}



