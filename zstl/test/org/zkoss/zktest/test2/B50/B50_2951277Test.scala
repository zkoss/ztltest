/* B50_2951277Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_2951277Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
You should see the value <label id="l" style="font-weight:bold"/> in the textbox.
<separator/>
<textbox id="test" cols="35"/>
<zscript>
test.setText("Just a \"test\" with quotes");
l.setValue("Just a \"test\" with quotes");
</zscript>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val l = ztl$engine.$f("l")
    val test = ztl$engine.$f("test")
    runZTL(zscript, () => {
      verifyEquals("Just a \"test\" with quotes", test.get("value"));
    })
  }
}



