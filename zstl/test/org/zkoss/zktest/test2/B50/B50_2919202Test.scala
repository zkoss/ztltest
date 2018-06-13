/* B50_2919202Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_2919202Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<vbox>
				<html><![CDATA[
				Test listbox + constraint:
				<ul>
					<li>Click show, then an error box shall be shown beside the listbox</li>
					<li>Click close, then the box shall disappear</li>
					<li>Click show again, and click toggle several times to see if
					the box shows and disappears with the listbox</li>
				</ul>
				]]></html>
				<listbox id="mylistbox" rows="1" mold="select">
				<listitem label="Inbox"/>
				<listitem label="Received"/>
				<listitem label="Draft"/>
				</listbox>
				<button id="show" label="show" onClick='throw new WrongValueException(mylistbox,
				"error")'/>
				<button id="close" label="close" onClick="Clients.clearWrongValue(mylistbox)"/>
				<button id="toggle" label="toggle" onClick="mylistbox.visible = !mylistbox.visible"/>
				</vbox>			
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val mylistbox = ztl$engine.$f("mylistbox")
    val show = ztl$engine.$f("show")
    val close = ztl$engine.$f("close")
    val toggle = ztl$engine.$f("toggle")
    runZTL(zscript, () => {
      verifyTrue(jq("@select > option ").exists())
      click(show)
      waitResponse()
      verifyTrue(jq(".z-errorbox").exists())
      click(close)
      waitResponse()
      verifyFalse(jq(".z-errorbox").exists())
      click(show)
      waitResponse()
      click(toggle)
      waitResponse()
      click(close); // errorbox cant be hidden in simulate env
      waitResponse()
      verifyFalse(jq(".z-errorbox").exists())
      verifyFalse(isVisible(jq("@select")))
      click(toggle)
      waitResponse()
      verifyTrue(isVisible(jq("@select")))
    })
  }
}



