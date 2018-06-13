/* B50_3165056Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_3165056Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
			<li>Open the bandbox.</li>
			<li>type some text in the textbox.</li>
			<li>click the button.</li>
			<li>The text shall be show in the model window.</li>
		</ol>
	]]></html>
	<bandbox id="bb">
		<bandpopup>
			Textbox: <textbox id="tb" />
		</bandpopup>
	</bandbox>
	<button label="show values" onClick='alert(tb.value)' />
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val bb = ztl$engine.$f("bb")
    val tb = ztl$engine.$f("tb")
    runZTL(zscript, () => {
      click(bb.$n("btn"))
      waitResponse()
      typeKeys(tb, "xxx")
      click(jq("@button"))
      waitResponse()
      verifyEquals("xxx", getAlertMessage())
    })
  }
}



