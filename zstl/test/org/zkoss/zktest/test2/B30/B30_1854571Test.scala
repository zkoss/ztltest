/* B30_1854571Test.java

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


class B30_1854571Test extends ZTL4ScalaTestCase {
  @Test
  def testClosing() = {
    var zscript =
      """
				<zk>
					<window id="myWin" title="Messagebox demo" border="normal">
						First, click the Test button. After four seconds, a message box appears.
						Then, you shall be able to close the message box by clicking the button.
						However, in 3.0.1, you have to click twice.
						<button id="myBtn" label="Test" width="100px">
						<attribute name="onClick">{
						Thread.sleep(4000);
						alert("See if you can close it in only click");
						}</attribute>
						</button>
					</window>
				</zk>
			 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val myWin = ztl$engine.$f("myWin")
    val myBtn = ztl$engine.$f("myBtn")
    runZTL(zscript, () => {
      click(jq(myBtn))
      waitResponse()
      verifyTrue(jq(".z-window-highlighted").exists())
      click(jq(".z-messagebox-window").toWidget().$n("close"))
      waitResponse()
      verifyFalse(jq(".z-window-highlighted").exists())
    })
  }
}



