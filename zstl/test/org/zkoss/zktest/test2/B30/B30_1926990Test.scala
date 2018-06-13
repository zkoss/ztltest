/* B30_1926990Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1926990Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window title="Btn Visibility" width="300px" border="normal">
Clicks <button label="show or hide">
<attribute name="onClick">
tb.buttonVisible = cb.buttonVisible = db.buttonVisible = bb.buttonVisible
= !tb.buttonVisible;
</attribute>
</button> and you shall see the button shown up together.
<separator bar="true"/>
<timebox id="tb" buttonVisible="false"/>
<separator/>
<combobox id="cb" buttonVisible="false"/>
<separator/>
<datebox id="db" buttonVisible="false"/>
<separator/>
<bandbox id="bb" buttonVisible="false"/>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tb = ztl$engine.$f("tb")
    val cb = ztl$engine.$f("cb")
    val db = ztl$engine.$f("db")
    val bb = ztl$engine.$f("bb")
    runZTL(zscript, () => {
      var btn0 = jq(tb.$n("btn"))
      var btn1 = jq(cb.$n("btn"))
      var btn2 = jq(db.$n("btn"))
      var btn3 = jq(bb.$n("btn"))
      verifyFalse(btn0.isVisible())
      verifyFalse(btn1.isVisible())
      verifyFalse(btn2.isVisible())
      verifyFalse(btn3.isVisible())
      click(jq("@button:eq(0)"))
      waitResponse()
      verifyTrue(btn0.isVisible())
      verifyTrue(btn1.isVisible())
      verifyTrue(btn2.isVisible())
      verifyTrue(btn3.isVisible())
    })
  }
}



