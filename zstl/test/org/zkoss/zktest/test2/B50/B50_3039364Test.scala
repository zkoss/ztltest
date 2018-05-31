/* B50_3039364Test.java

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
import org.zkoss.ztl.Widget


class B50_3039364Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
<html><![CDATA[
<ul>
 <li>Click the "click" button, and a popup shall show up (IE).</li>
 <li>Click the "200px" button to enlarge the popup.</li>
 <li>Click the "100px" button to shrink the popup.</li>
</ul>
]]></html>
<popup id="pop" width="100px" height="100px">
<button label="100px" onClick='self.parent.height = "100px"' />
<button label="200px" onClick='self.parent.height = "200px"' />
</popup>
<button label="click" onClick="pop.open(self);" />
<separator height="100px" />
<listbox mold="select" width="300px" />
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val pop = ztl$engine.$f("pop")
    runZTL(zscript, () => {
      click(jq("@button[label=\"click\"]"))
      waitResponse()
      verifyTrue(isVisible(pop))
      click(jq("@button[label=\"200px\"]"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      verifyEquals("200", jq(pop).outerHeight())
      click(jq("@button[label=\"100px\"]"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
      verifyEquals("100", jq(pop).outerHeight())
    })
  }
}



