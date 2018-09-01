/* B50_3026292Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3026292Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
<html>
<![CDATA[
<ol>
	<li>Click the button</li>
	<li>Check the label, it shall in the bandpopup of the bandbox</li>
</ol>
]]>
</html>
	<zscript><![CDATA[
		void addPop(){
			Bandpopup bandpopup = new Bandpopup();
			bandpopup.setParent(bandbox);
			bandpopup.appendChild(new Label("label"));
		}
	]]></zscript>
	<bandbox id="bandbox"/>
	<button id="b" label="add bandpopup" onClick="addPop()"/>
</zk>

		"""
    val ztl$engine = engine()
    val bandbox = ztl$engine.$f("bandbox")
    val b = ztl$engine.$f("b")
    runZTL(zscript, () => {
      click(b)
      waitResponse()
      click(bandbox.$n("btn"))
      waitResponse()
      verifyEquals("label", jq(jq(".z-bandbox").toWidget().$n("pp")).find(".z-label").text())
    })
  }
}



