/* B50_2922847Test.java

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


class B50_2922847Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
				Please cleck the toolbarbutton label to see the font should be bold
				<toolbarbutton id="tbtn" label="click me" style="font-weight:bold" 
						onClick='self.style = self.style.equals("font-weight:bold;") ? "font-weight:bold;":"font-weight:normal;"'/>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tbtn = ztl$engine.$f("tbtn")
    runZTL(zscript, () => {
      if (!("bold".equals(jq(".z-toolbarbutton-content")
        .css("font-weight"))
        || "700".equals(jq(".z-toolbarbutton-content").css(
        "font-weight"))))
        verifyTrue(false)
      click(tbtn)
      waitResponse()
      if (!("normal".equals(jq(".z-toolbarbutton-content").css(
        "font-weight"))
        || "400".equals(jq(".z-toolbarbutton-content").css(
        "font-weight"))))
        verifyTrue(false);
    })
  }
}



