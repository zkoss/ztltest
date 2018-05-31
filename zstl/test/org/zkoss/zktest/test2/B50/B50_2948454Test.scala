/* B50_2948454Test.java

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
import org.zkoss.ztl.Widget


class B50_2948454Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
	<html><![CDATA[
	<ol>
		<li>Click "move button"</li>
		<li>Then, click "test" and you shall see the "success: target" message</li>
	</ol>
	]]></html>
 <zscript><![CDATA[
  move() {
	Div div = new Div();
	div.appendChild(win);
	cave.appendChild(div);
  }
]]></zscript>
 <button label="move button" onClick="move()"/>
 <window id="cave" border="normal">
 	<label id="inf" value="target"/>
 </window>

 <window id="win">
  <zscript>
  //nothing but force it to be evaluated
  </zscript>
  <button label="click" onClick='alert("success:" + inf.value)' />
 </window>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cave = ztl$engine.$f("cave")
    val inf = ztl$engine.$f("inf")
    val win = ztl$engine.$f("win")
    runZTL(zscript, () => {
      click(jq("@button[label=\"move button\"]"))
      waitResponse()
      click(jq("@button[label=\"click\"]"))
      waitResponse()
      verifyEquals("success:target", jq(".z-messagebox .z-label").html())
    })
  }
}



