/* B50_2997975Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.JQuery

class B50_2997975Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    val ztl$engine = engine()
    val d = ztl$engine.$f("d")
    val c = ztl$engine.$f("c")
    val b = ztl$engine.$f("b")
    val t = ztl$engine.$f("t")
    val s = ztl$engine.$f("s")
    val btn = ztl$engine.$f("btn")
    runZTL(() => {
      click(b.$n("real"))
      waitResponse(true)
      verifyFalse(isVisible(b.$n("pp")))
      checkButtonDisplay(jq(b.$n("btn")), false)
      click(c.$n("real"))
      waitResponse(true)
      verifyFalse(isVisible(c.$n("pp")))
      checkButtonDisplay(jq(c.$n("btn")), false)
      click(d.$n("real"))
      waitResponse(true)
      verifyFalse(isVisible(d.$n("pp")))
      checkButtonDisplay(jq(d.$n("btn")), false)
      checkButtonDisplay(jq(t.$n("btn")), false)
      checkButtonDisplay(jq(s.$n("btn")), false)
      click(btn)
      click(b.$n("real"))
      waitResponse(true)
      verifyFalse(isVisible(b.$n("pp")))
      checkButtonDisplay(jq(b.$n("btn")), true)
      click(c.$n("real"))
      waitResponse(true)
      verifyTrue(isVisible(c.$n("pp")))
      checkButtonDisplay(jq(c.$n("btn")), true)
      click(d.$n("real"))
      waitResponse(true)
      verifyTrue(isVisible(d.$n("pp")))
      checkButtonDisplay(jq(d.$n("btn")), true)
      checkButtonDisplay(jq(t.$n("btn")), true)
      checkButtonDisplay(jq(s.$n("btn")), true)
    })
  }

  def checkButtonDisplay(jqbtn: JQuery, shallDisplay: Boolean) = {
    if (shallDisplay)
      verifyNotEquals("none", jqbtn.css("display"))
    else
      verifyEquals("none", jqbtn.css("display"))
  }
}



