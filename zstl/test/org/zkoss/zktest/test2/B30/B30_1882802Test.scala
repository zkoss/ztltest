/* B30_1882802Test.java

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


class B30_1882802Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
      click enable/disable and make sure every one is disable/enabled
      <vbox>
	<button label="enable/disable"
		onClick="a1.disabled= !a1.disabled;a2.disabled= !a2.disabled;a3.disabled= !a3.disabled;a4.disabled= !a4.disabled;a5.disabled= !a5.disabled;a6.disabled= !a6.disabled;a7.disabled= !a7.disabled;" />
	<textbox id="a1" rows="5" cols="40">
		<attribute name="value">text line1... text line2...</attribute>
	</textbox>
	<datebox id="a2" />
	<combobox id="a3">
		<comboitem label="item1" value="item1value" />
		<comboitem label="item1" value="item1value" />
	</combobox>
	<textbox id="a4" />
	<intbox id="a5" />
	<radiogroup>
		<radio id="a6" label="Apple" />
	</radiogroup>
	<checkbox id="a7" label="Apple" />
      </vbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val a1 = ztl$engine.$f("a1")
    val a2 = ztl$engine.$f("a2")
    val a3 = ztl$engine.$f("a3")
    val a4 = ztl$engine.$f("a4")
    val a5 = ztl$engine.$f("a5")
    val a6 = ztl$engine.$f("a6")
    val a7 = ztl$engine.$f("a7")
    runZTL(zscript, () => {
      verifyEquals(0, jq(":disabled").length())
      click(jq("@button"))
      waitResponse()
      verifyEquals(7, jq(":disabled").length())
    })
  }
}



