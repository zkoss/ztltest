/* B50_2997079Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.util._


class B50_2997079Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<window id="main" xmlns:w="http://www.zkoss.org/2005/zk/client">
	<label id="i" value="Click test1 and then test2. Then, you shall see the background becomes blue"/>
	<button label="test1">
		<attribute name="onClick"><![CDATA[
	Script s = new Script();
	s.setContent("function chkgnd(n) {n.setStyle('background:blue');}");
	s.setParent(main);
		]]></attribute>
	</button>
	<button label="test2" w:onClick="chkgnd(this.$f().i)"/>
</window>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val main = ztl$engine.$f("main")
    val i = ztl$engine.$f("i")
    runZTL(zscript, () => {
      click(jq("@button[label=\"test1\"]"))
      waitResponse()
      click(jq("@button[label=\"test2\"]"))
      waitResponse()
      var css = jq(".z-label").css("background-color")
      verifyTrue("css: [" + css + "]", ColorVerifingHelper.isEqualColor("blue", css));
    })
  }
}



