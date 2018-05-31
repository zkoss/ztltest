/* B50_2959024Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2959024Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
<zscript>
import org.zkoss.zk.ui.util.*;
</zscript>
<div height="100px" width="300px" id="div">
  <attribute name="onLater">
  Thread.sleep(3000);
  Clients.clearBusy();
alert(event.data);
  </attribute>
</div>
<button label="Click Me">
	<attribute name="onClick">
		Clients.showBusy("You should see an alert about the result after 2 seconds.");
		Events.echoEvent("onLater", div, "If you can see the message, the bug is fixed!");
	</attribute>
</button>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val div = ztl$engine.$f("div")
    runZTL(zscript, () => {
      click(jq("@button"))
      sleep(5000)
      verifyTrue(jq("@window").exists())
    })
  }
}



