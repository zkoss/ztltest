/* B30_1736858Test.java

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


class B30_1736858Test extends ZTL4ScalaTestCase {
  @Test
  def testSession() = {
    var zscript =
      """
		<window title="Memory Leak Test">
		<button id="btn" label="Invalidate Session">
			<attribute name="onClick">
			info.value = "Then, check whether any instance of desktop remains (by use of jhat or other tools)";
			session.invalidate();
			</attribute>
		</button>
		<label id="info"/>
		</window>
		 """
    val ztl$engine = engine()
    val btn = ztl$engine.$f("btn")
    val info = ztl$engine.$f("info")
    runZTL(zscript, () => {
      click(btn); // here there doesn't exsit anything in zk session
      waitResponse()
      verifyTrue(btn.exists())
      click(btn); // here will be a timeout
      sleep(1000)
      verifyContains(getEval("location.href"), "timeout.zul")
    })
  }
}



