/* B30_1778258Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1778258Test extends ZTL4ScalaTestCase {
  @Test
  def testFulfill() = {
    var zscript =
      """
			<?taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c"?>
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:p>It's true, you should see the image after you click the button.</n:p>
			<window id="w1" title="Foo">
			<button id="btn1" label="click me"/>
			<vbox id="w2" fulfill="btn1.onClick">
			<div style="padding: 10px; background:
			url(${c:encodeURL('/img/battery.gif')});">
			ABCD
			</div>
			</vbox>
			</window>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val w1 = ztl$engine.$f("w1")
    val btn1 = ztl$engine.$f("btn1")
    val w2 = ztl$engine.$f("w2")
    runZTL(zscript, () => {
      verifyFalse(jq("@box @div").exists())
      click(btn1)
      waitResponse()
      verifyTrue(jq("@box @div").exists())
    })
  }
}



