/* B30_1969455Test.java

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


class B30_1969455Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window id="w" onA='l1.value += "A"' onB='l1.value += "B"'>
	You shall see "AB" is generated when clicking
	<button label="Test" forward="onA,onB"/>
	<label id="l1"/>
	<separator/>
	<div id="c" onC="l2.value += event.data"/>
	You shall see "XY" is generated when clicking
	<button label="Test" forward="${c}.onC(XY)"/>
	<label id="l2"/>
	<separator/>
	<div id="d" onD="l3.value += event.data"/>
	You shall see "ZK" is generated when clicking
	<variables data="ZK"/>
	<button label="Test" forward="${d}.onD(${data})"/>
	<label id="l3"/>
</window>

		"""
    val ztl$engine = engine()
    val w = ztl$engine.$f("w")
    val l1 = ztl$engine.$f("l1")
    val c = ztl$engine.$f("c")
    val l2 = ztl$engine.$f("l2")
    val d = ztl$engine.$f("d")
    val l3 = ztl$engine.$f("l3")
    runZTL(zscript, () => {
      click(jq("@button:eq(0)"));
      waitResponse()
      verifyEquals("AB", jq(l1).text())
      click(jq("@button:eq(1)"));
      waitResponse()
      verifyEquals("XY", jq(l2).text())
      click(jq("@button:eq(2)"));
      waitResponse()
      verifyEquals("ZK", jq(l3).text())
    })
  }
}



