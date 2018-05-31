/* B50_2997975Test.java

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


class B50_2997975Test extends ZTL4ScalaTestCase {
  @Test
  def testButtonVisible() = {
    var zscript =
      """
<zk>
<datebox id="d" readonly="true" buttonVisible="false"/>
<combobox id="c" readonly="true" buttonVisible="false"/>
<bandbox id="b" readonly="true" buttonVisible="false"/>
<timebox id="t" readonly="true" buttonVisible="false"/>
<spinner id="s" readonly="true" buttonVisible="false"/>
<button id="btn" label="invisible/visible"
 onClick='b.buttonVisible = !b.buttonVisible;c.buttonVisible = !c.buttonVisible;d.buttonVisible = !d.buttonVisible;t.buttonVisible = !t.buttonVisible;s.buttonVisible = !s.buttonVisible'/>
</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val d = ztl$engine.$f("d")
    val c = ztl$engine.$f("c")
    val b = ztl$engine.$f("b")
    val t = ztl$engine.$f("t")
    val s = ztl$engine.$f("s")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      click(b.$n("real"))
      waitResponse(true)
      verifyFalse(isVisible(b.$n("pp")))
      verifyEquals("1px", jq(b.$n("real")).css("border-right-width"))
      click(c.$n("real"))
      waitResponse(true)
      verifyFalse(isVisible(c.$n("pp")))
      verifyEquals("1px", jq(c.$n("real")).css("border-right-width"))
      click(d.$n("real"))
      waitResponse(true)
      verifyFalse(isVisible(d.$n("pp")))
      verifyEquals("1px", jq(d.$n("real")).css("border-right-width"))
      verifyEquals("1px", jq(t.$n("real")).css("border-right-width"))
      verifyEquals("1px", jq(s.$n("real")).css("border-right-width"))
      click(btn)
      click(b.$n("real"))
      waitResponse(true)
      verifyFalse(isVisible(b.$n("pp")))
      verifyEquals("0px", jq(b.$n("real")).css("border-right-width"))
      click(c.$n("real"))
      waitResponse(true)
      verifyTrue(isVisible(c.$n("pp")))
      verifyEquals("0px", jq(c.$n("real")).css("border-right-width"))
      click(d.$n("real"))
      waitResponse(true)
      verifyTrue(isVisible(d.$n("pp")))
      verifyEquals("0px", jq(d.$n("real")).css("border-right-width"))
      verifyEquals("0px", jq(t.$n("real")).css("border-right-width"))
      verifyEquals("0px", jq(s.$n("real")).css("border-right-width"))
    })
  }
}



