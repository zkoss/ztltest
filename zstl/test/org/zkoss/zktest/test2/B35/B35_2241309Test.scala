/* B35_2241309Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B35_2241309Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<window id="myWindow" title="My First Window" border="normal" width="500px">
			<html><![CDATA[
			<ol>
			<li>You shall see two buttons "Ok" and "Ok2".</li>
			<li>Press "Ok2" button, and you shall see the "Ok2" changed to "NewLabel".</li>
			<li>Done</li>
			</ol>
			]]></html>
				<button id="btn1" label="Ok" apply="org.zkoss.zktest.test2.B2241309Composer"/>
				<zscript><![CDATA[
					Button btn2 = btn1.clone();
					btn2.setId("btn2");
					btn2.setLabel("Ok2");
					btn2.setParent(myWindow);
				]]></zscript>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val myWindow = ztl$engine.$f("myWindow")
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    runZTL(zscript, () => {
      click(btn2)
      waitResponse()
      verifyEquals("NewLabel", jq(".z-button:eq(1)").text())
    })
  }
}



