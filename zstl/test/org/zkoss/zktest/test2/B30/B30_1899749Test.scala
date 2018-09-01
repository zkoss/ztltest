/* B30_1899749Test.java

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


class B30_1899749Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window title="Test of Progressmetter">
	<html><![CDATA[
<p>At beginning, it shall be 30%.</p>
Case 1:
<ol>
<li>Click "width 200" and it shall scale correctly.</li>
<li>Click "hide", then "set 80", then, "show" and it shall be 80%.</li>
<li>Click "hide", then "width 100", then, "show" and it shall be 80% and 100px width.</li>
</ol>
Case 2: With IE6,
<ol>
<li>Click "set 80", "width 200" and "width 100"</li>
</li>
	]]></html>

	<div id="sp">
		<progressmeter width="100px" id="pm" value="30"/>
	</div>
	<button label="set 0" onClick="pm.setValue(0)"/>
	<button label="set 10" onClick="pm.setValue(10)"/>
	<button label="set 80" onClick="pm.setValue(80)"/>
	<button label="set 100" onClick="pm.setValue(100)"/>
	<button label="width 200">
		<attribute name="onClick">pm.setWidth("200px")</attribute>
	</button>
	<button label="width 100">
		<attribute name="onClick">pm.setWidth("100px")</attribute>
	</button>
	<button label="hide" onClick="sp.setVisible(false)"/>
	<button label="show" onClick="sp.setVisible(true)"/>
</window>

		"""
    val ztl$engine = engine()
    val sp = ztl$engine.$f("sp")
    val pm = ztl$engine.$f("pm")
    runZTL(zscript, () => {
      var $progress = jq("@progressmeter")
      var $img = jq($progress.toWidget().$n("img"))
      waitResponse(true)
      verifyTolerant(30, ($img.width() * 100) / $progress.width(), 2)
      verifyTolerant(30, $img.width(), 2)
      verifyEquals(100, $progress.outerWidth())
      click(jq("@button:eq(4)")); //width 200
      waitResponse(true)
      verifyTolerant(30, ($img.width() * 100) / $progress.width(), 2)
      verifyTolerant(60, $img.width(), 2)
      verifyEquals(200, $progress.outerWidth())
      click(jq("@button:eq(2)")); //set 80
      waitResponse(true)
      verifyTolerant(160, $img.width(), 2)
      verifyEquals(200, $progress.outerWidth())
      click(jq("@button:eq(6)")); //hide
      waitResponse(true)
      click(jq("@button:eq(5)")); //width 100
      waitResponse(true)
      click(jq("@button:eq(7)")); //show
      waitResponse(true)
      verifyTolerant(80, ($img.width() * 100) / $progress.width(), 2)
      verifyTolerant(80, $img.width(), 2)
      verifyEquals(100, $progress.outerWidth())
    })
  }
}



