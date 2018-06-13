/* B30_1773575Test.java

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


class B30_1773575Test extends ZTL4ScalaTestCase {
  @Test
  def testURL() = {
    var zscript =
      """
		<window title="HashTest" onOK="setHash()">
		<html><![CDATA[
		1. Open new browser. <br/>
		2. Click the B30-1773575.zul, you should not see "?" appended to the URL. <br/>
		3. Click the B30-1773575.zul#12345, you should not see "?" in the URL. And press second time should not get js loop.<br/>
		<br/>
		]]></html>
		
		<vbox>
		Enter URL fragment (hash):
		<textbox id="tb" />
		
		<hbox>Current fragment for db querries:
		<label id="hash" />
		</hbox>
		<button id="btn1" href="" label="B30-1773575.zul" />
		<button id="btn2" href="#12345" label="B30-1773575.zul#12345" />
		</vbox>
		<zscript>
		setHash(){
		desktop.setBookmark(tb.value);
		hash.setValue(desktop.getBookmark());
		}
		</zscript>
		</window>		
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tb = ztl$engine.$f("tb")
    val hash = ztl$engine.$f("hash")
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    runZTL(zscript, () => {
      click(btn1)
      waitResponse()
      verifyTrue(getLocation().indexOf("?") < 0)
      click(btn2)
      waitResponse()
      verifyTrue(getLocation().indexOf("?") < 0)
      verifyTrue(getLocation().endsWith("#12345"))
    })
  }
}



