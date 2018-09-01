/* F30_1735287Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class F30_1735287Test extends ZTL4ScalaTestCase {
  @Test
  def testEvent() = {
    var zscript =
      """
		<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:h2>[ 1735287 ] Disable Toolbarbutton</n:h2>
			<n:ol>
				<n:li>Click the button1 and button3(gray link), then you should not see any dialog.</n:li>
				<n:li>Click the enable btn1 and enable btn3, now you can click button1 and button3 showing alert message.</n:li>
			</n:ol>
			<window title="Disable Toolbarbutton" border="normal" width="300px">
				<caption>
					<toolbarbutton id="btn3" disabled="true" label="button3" onClick='alert("You should not see this dialog!");'/>
					<toolbarbutton id="en3" label="enable btn3" onClick="btn3.disabled=false"/>
				</caption>
				<toolbar>
					<toolbarbutton id="btn1" disabled="true" label="button1" onClick='alert("You should not see this dialog!");'/>
					<toolbarbutton id="en1" label="enable btn1" onClick="btn1.disabled=false"/>
				</toolbar>
			</window>
		</zk>
		 """
    val ztl$engine = engine()
    val btn3 = ztl$engine.$f("btn3")
    val en3 = ztl$engine.$f("en3")
    val btn1 = ztl$engine.$f("btn1")
    val en1 = ztl$engine.$f("en1")
    runZTL(zscript, () => {
      var msgbox = ".z-messagebox-window"
      verifyFalse(jq(msgbox).exists())
      click(btn1)
      waitResponse()
      verifyFalse(jq(msgbox).exists())
      click(btn3)
      waitResponse()
      verifyFalse(jq(msgbox).exists())
      click(en1)
      waitResponse()
      click(btn1)
      waitResponse()
      verifyTrue(jq(msgbox).exists())
      click(jq(".z-messagebox-button"))
      waitResponse()
      verifyFalse(jq(msgbox).exists())
      click(en3)
      waitResponse()
      click(btn3)
      waitResponse()
      verifyTrue(jq(msgbox).exists())
    })
  }
}



