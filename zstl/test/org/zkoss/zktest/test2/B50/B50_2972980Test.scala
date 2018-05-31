/* B50_2972980Test.java

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


class B50_2972980Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
<html><![CDATA[
<ol>
<li>Click the "add listener" button first</li>
<li>Then click "Click Me", and then you shall see a "onClick" dialog shown up</li>
</ol>
]]></html>
	<div id="d" style="border:1px solid blue">Click Me</div>
	<button label="add listener" onClick='d.setWidgetListener("onClick", "jq.alert(event.name)")'/>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val d = ztl$engine.$f("d")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      click(jq("@label"))
      waitResponse()
      verifyTrue(jq(".z-window-modal").exists())
    })
  }
}



