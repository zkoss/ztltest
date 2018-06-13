/* B50_3189142Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3189142Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk> 
Please type a word into the textbox, you shouldn't see the width of the popup is wrong. (IE7 only)
<combobox id="cb" autodrop="true" onOpen=""> 
<comboitem label="1"/> 
<comboitem label="2"/> 
<comboitem label="3"/> 
</combobox> 
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      focus(cb.$n("real"))
      keyPress(cb.$n("real"), "A")
      waitResponse()
      verifyTrue(jq(jq(".z-combobox").toWidget().$n("pp")).exists())
      verifyTrue(getElementWidth(jq(jq(".z-combobox").toWidget().$n("pp"))).intValue() > 0)
      var cbx = getElementWidth(jq(".z-combobox")).intValue()
      var pp = getElementWidth(jq(jq(".z-combobox").toWidget().$n("pp"))).intValue()
      verifyTolerant(cbx, pp, 6)
    })
  }
}



