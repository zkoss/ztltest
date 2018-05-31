/* B50_3086452Test.java

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


class B50_3086452Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
Clicks the collapse button to open/close the following two boxes.
Their behavior shall be the same: the total height won't be changed.

<vbox height="200px" style="border:3px black solid">
Column 1-1: The left-top box. To know whether a splitter is
collapsed, you can listen to the onOpen event.
<splitter id="s1" collapse="after" open="false"></splitter>
Column 1-2: You can enforce to open or collapse programming by
calling setOpen method.
</vbox>
<vbox height="200px" style="border:3px black solid">
Column 1-1: The left-top box. To know whether a splitter is
collapsed, you can listen to the onOpen event.
<splitter id="s2" collapse="after" open="true"></splitter>
Column 1-2: You can enforce to open or collapse programming by
calling setOpen method.
</vbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val s1 = ztl$engine.$f("s1")
    val s2 = ztl$engine.$f("s2")
    runZTL(zscript, () => {
      var h = jq(".z-vbox:eq(0)").height() + jq(".z-vbox:eq(1)").height()
      click(s1.$n("btn"))
      waitResponse()
      click(s2.$n("btn"))
      waitResponse()
      var h1 = jq(".z-vbox:eq(0)").height() + jq(".z-vbox:eq(1)").height()
      verifyTolerant(h1, h, 5)
    })
  }
}



