/* B50_3035847Test.java

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


class B50_3035847Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	Click the drop-down button, and the combobox shall be detached.
	<separator/>
	Bug: the popup remains when combobox is detached.
	<separator/>
	<combobox id="cb" onOpen="self.detach()">
		<comboitem forEach="1,1,1,1,1,1,1" label="item" />
	</combobox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      click(cb.$n("btn"))
      waitResponse()
      verifyFalse(jq("@comboitem").exists())
    })
  }
}



