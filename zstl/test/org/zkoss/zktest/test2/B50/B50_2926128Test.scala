/* B50_2926128Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2926128Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					1. The Datebox below should has value inside
					<separator/>
					2. Click this <button id="btn1" label="Set Null Value" onClick="db.setValue(null);"/>, the Datebox below should become empty
					<separator/>
					3. Click this <button id="btn2" label="Get Datebox Value" onClick="alert(db.getValue());"/>, it will popup a window, and the text inside should be "null"
					<separator/>
					4. Click this <button id="btn3" label="Set Current Date" onClick="db.setValue(new Date())"/>, the Datebox should set current date. And doesn't popup a Calendar. If a Calendar popup, it's wrong.
					<separator/>
					<datebox id="db" onCreate="db.setValue(new Date());"/>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val btn3 = ztl$engine.$f("btn3")
    val db = ztl$engine.$f("db")
    runZTL(zscript, () => {
      verifyNotEquals("", jq(jq(".z-datebox").toWidget().$n("real")).`val`())
      var x = jq(jq(".z-datebox").toWidget().$n("real")).`val`()
      click(btn1)
      waitResponse()
      verifyEquals("", jq(jq(".z-datebox").toWidget().$n("real")).`val`())
      click(btn2)
      waitResponse()
      verifyEquals("null", jq(".z-window-highlighted .z-messagebox .z-label").text())
      click(jq(".z-window-highlighted .z-button"))
      waitResponse()
      click(btn3)
      waitResponse()
      verifyEquals(x, jq(jq(".z-datebox").toWidget().$n("real")).`val`());
    })
  }
}



