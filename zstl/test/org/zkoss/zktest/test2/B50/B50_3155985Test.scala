/* B50_3155985Test.java

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


class B50_3155985Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
<zscript><![CDATA[
long begin = 0;
class MyComposer extends org.zkoss.zk.ui.util.GenericForwardComposer {
	public void onClick$btn() {
		timer.stop();
		timer.start();
		begin = System.currentTimeMillis();
		inf.appendChild(new Label("timer started"));
	}
	public void onTimer$timer() {
		inf.appendChild(new Label("timer fired: " + (System.currentTimeMillis() - begin) /1000));
	}
}
]]></zscript>
<div apply="MyComposer">
<html><![CDATA[
	<ol>
	<li>Click the Fire button</li>
	<li>Then, "timer started" apears, and after 3 seconds, "timer fired: 3" appears</li>
	</ol>
]]></html>

<timer id="timer" running="false" repeats="false" delay="3000" />
<button id="btn" label="Fire"/>
<vlayout id="inf"/>
</div>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val timer = ztl$engine.$f("timer")
    val btn = ztl$engine.$f("btn")
    val inf = ztl$engine.$f("inf")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyEquals("timer started", (jq("@label:eq(0)").text()))
      sleep(2000)
      verifyEquals("", (jq("@label:eq(1)").text()))
      sleep(1500)
      verifyContains((jq("@label:eq(1)").text()), "timer fired:")
    })
  }
}



