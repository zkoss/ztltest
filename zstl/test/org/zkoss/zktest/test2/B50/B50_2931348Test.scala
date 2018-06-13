/* B50_2931348Test.java

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


class B50_2931348Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
1. Click this <button label="Set Iframe Name" onClick='iframe1.setName("iframe1")'></button>, if popup a error message box, it's wrong
<separator height="20px"/>
<iframe id="iframe1"/>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val iframe1 = ztl$engine.$f("iframe1")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq(".z-errorbox").exists())
    })
  }
}



