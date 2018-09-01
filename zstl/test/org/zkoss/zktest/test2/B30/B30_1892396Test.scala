/* B30_1892396Test.java

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


class B30_1892396Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window title="Clone test">
	<vbox>
<html><![CDATA[
Steps:<br/>
1. Type "mm" to the first textbox<br/>
2. Type "kk" to the second textbox, and you shall see "kk" is shown instead of "mm". 
]]></html>

	<label style="background:blue;color:white;" id="l"/>
	<textbox id="t1" onChange="l.value = self.value"/>
	</vbox>
	<zscript>
	Textbox t2 = t1.clone();
	t2.setId("t2");
	t2.setParent(t1.parent);
	</zscript>
</window>

		"""
    val ztl$engine = engine()
    val l = ztl$engine.$f("l")
    val t1 = ztl$engine.$f("t1")
    val t2 = ztl$engine.$f("t2")
    runZTL(zscript, () => {
      focus(t1)
      sendKeys(t1, "mm")
      blur(t1)
      waitResponse()
      verifyEquals("mm", l.attr("value"))
      focus(t2)
      typeKeys(t2, "kk")
      blur(t2)
      waitResponse()
      verifyEquals("kk", l.attr("value"))
    })
  }
}



