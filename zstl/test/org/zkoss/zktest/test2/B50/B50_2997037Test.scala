/* B50_2997037Test.java

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


class B50_2997037Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
<html>
<![CDATA[
<ol>
<li>Press "setLong" button. You shall see 9223372036854775807 show in the longbox.</li>
<li>In the longbox, change the last digit from 7 to 8, so the number become 9223372036854775808 and Tab away.</li>
<li>You shall see pop errorbox "Out of range(-9223372036854775808 - 9223372036854775807)"</li>
<li>In the longbox, add before the first digit with a negative sign, so the number become -9223372036854775808 and Tab away.</li>
<li>You shall NOT see any errorbox</li>
<li>In the longbox, change the last digit from 8 to 9, so the number become -9223372036854775809 and Tab away.</li>
<li>You shall see pop errorbox "Out of range(-9223372036854775808 - 9223372036854775807)"</li>
<li>done</li>
</ol>
]]>
</html>
<vbox>
longbox:<longbox id="longbx" width="300px"/>
<button id="btn" label="setLong" onClick="longbx.setValue(new Long(9223372036854775807L))"/>
</vbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val longbx = ztl$engine.$f("longbx")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyEquals("9223372036854775807", jq(".z-longbox").`val`())
      focus(longbx.$n())
      longbx.$n().eval("value='9223372036854775808'")
      blur(longbx.$n())
      waitResponse()
      verifyEquals("9223372036854775808", jq(".z-longbox").`val`())
      verifyTrue(jq(".z-errorbox").exists())
      focus(longbx.$n())
      longbx.$n().eval("value='-9223372036854775808'")
      blur(longbx.$n())
      waitResponse()
      verifyEquals("-9223372036854775808", jq(".z-longbox").`val`())
      verifyFalse(jq(".z-errorbox").exists())
      focus(longbx.$n())
      longbx.$n().eval("value='-9223372036854775809'")
      blur(longbx.$n())
      waitResponse()
      verifyEquals("-9223372036854775809", jq(".z-longbox").`val`())
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



