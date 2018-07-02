/* B36_2811990Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2811990Test extends ZTL4ScalaTestCase {
  @Test
  def testtitle() = {
    var zscript =
      """
			<window title="My First Window" border="normal" width="600px">
			<html><![CDATA[
			<ol>
			<li>Move mouse to the Slider's nob, the tooltiptext shall be "50"; if it
			does not show, it is a bug</li>
			<li>Drag the nob of the slider to "70"; move mouse to slider's nob, the
			tooltiptext shall be "70"; if it does not showw, it is a bug</li>
			<li>Press button to change curpos to 10</li>
			<li>Move mouse to the Slider's nobe, the tooltiptext shall be "10"; if it
			is NOT "10", it is a bug.</li>
			</ol>
			]]>
			</html>
			<slider id="sl" curpos="50"/>
			<button label="change slider's curpos to 10" onClick="sl.curpos=10"/>
			</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val sl = ztl$engine.$f("sl")
    runZTL(zscript, () => {
      var btn = jq("$sl").toWidget().$n("btn")
      verifyEquals(jq(btn).attr("title"), "50")
      dragdropTo(jq(btn), "8,6", "45,8")
      waitResponse()
      verifyEquals(jq(btn).attr("title"), "70")
      click(jq("@button"))
      waitResponse()
      verifyEquals(jq(btn).attr("title"), "10")
    })
  }
}



