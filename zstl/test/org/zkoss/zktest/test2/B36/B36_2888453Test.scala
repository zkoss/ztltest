/* B36_2888453Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2888453Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window id="win" title="Bug in IE">
please click the close button, and no JavaScript error is correct. (IE only)
<textbox constraint="no empty" focus="true"/>
<button label="close" forward="onClose"/>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



