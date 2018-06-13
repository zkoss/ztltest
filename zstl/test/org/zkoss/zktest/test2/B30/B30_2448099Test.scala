/* B30_2448099Test.java

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


class B30_2448099Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window id="win" title="My First Window" border="normal" width="400px">
<html>
<![CDATA[
<ol>
<li>FireFox only</li>
<li>Press "add onXyz&#36;Abc event listener" button.</li>
<li>You shall see nothing happened. Otherwise, it is a bug.</li>
<li>Done</li>
</ol>
]]>
</html>
<button label="add onXyz$Abc event listener">
<attribute name="onClick"><![CDATA[
win.addEventListener("onXyz$Abc", new EventListener() {
public void onEvent(Event evt) {
//do nothing
}
});
]]></attribute>
</button>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val win = ztl$engine.$f("win")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



