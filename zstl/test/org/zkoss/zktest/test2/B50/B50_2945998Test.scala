/* B50_2945998Test.java

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


class B50_2945998Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
<zscript>
Label x = new Label();
</zscript>
<window id="mywin" border="normal">
<custom-attributes a="${x}"/>
A window
</window>
Click 
<button label="test" onClick="new Div().appendChild(mywin)"/>
and you shall see the above window disappears
</zk>
			"""
    val ztl$engine = engine()
    val mywin = ztl$engine.$f("mywin")
    runZTL(zscript, () => {
      verifyTrue(mywin.exists())
      click(jq("@button"))
      waitResponse()
      verifyFalse(mywin.exists())
    })
  }
}



