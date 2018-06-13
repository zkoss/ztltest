/* B30_1455584Test.java

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
import org.zkoss.ztl.unit.Widget


class B30_1455584Test extends ZTL4ScalaTestCase {
  @Test
  def testClick() = {
    var zscript =
      """
			<vbox>
				Click "hello world", if you see the message change, it is ok.
				<zscript>
				public void doCreate(Event evt) {
					evt.target.setValue("    hello,\n  world");
				}
				public void doClick(Event evt) {
					evt.target.setValue("    I have\n  been   clicked");
				}
			</zscript>
				<label id="l1" onCreate="doCreate(event);" onClick="doClick(event)"
					style="font-family: monospace; white-space: pre;" />
				<label id="l2" onCreate="doCreate(event);" onClick="doClick(event)"
					pre="true" />
			</vbox>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val l1 = ztl$engine.$f("l1")
    val l2 = ztl$engine.$f("l2")
    runZTL(zscript, () => {
      var strClickBefor = getText(l1)
      clickAt(l1, "2,2"); // firefox need
      waitResponse()
      var strClickAfter = getText(l1);
      verifyNotEquals(strClickBefor, getText(l1))
      strClickBefor = getText(l2);
      clickAt(l2, "2,2")
      waitResponse();
      verifyNotEquals(strClickBefor, getText(l2))
    })
  }
}



