/* B30_1819264Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1819264Test extends ZTL4ScalaTestCase {
  @Test
  def testConstraint() = {
    var zscript =
      """
<borderlayout height="300px">
	<center autoscroll="true">
		<div height="500px">
			Please focus in the textbox, then focus out, and then when
			you scroll up/down the scroll bar, the error box should be
			moved according to the textbox.
			<separator />
			<textbox id="tb" value="show Error" constraint="/.+@.+\.[a-z]+/" />
		</div>
	</center>
</borderlayout>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tb = ztl$engine.$f("tb")
    runZTL(zscript, () => {
      var center = jq(".z-center").toWidget()
      focus(tb)
      blur(tb)
      sleep(300)
      verifyTrue(jq("@errorbox").exists())
      var str = jq("@errorbox").toElement().get("style.top").trim()
      var beforeTop = Math.round(str.substring(0, str.lastIndexOf("px")).toFloat)
      verScroll(center, 0.05)
      verifyTolerant(jq(tb).offsetTop(), jq("@errorbox").offsetTop(), 1)
      verScroll(center, 0)
      str = jq("@errorbox").toElement().get("style.top").trim()
      var afterTop = Math.round(str.substring(0, str.lastIndexOf("px")).toFloat)
      verifyTolerant(beforeTop, afterTop, 1)
    })
  }
}



