/* B50_3026819Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_3026819Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
<html>
<![CDATA[
<ol>
	<li>Click tab to navigator each textbox</li>
	<li>Check it will skip second textbox</li>
</ol>
]]>
</html>
	<div>
		<textbox id="txt1" value="tabindex1" />
		<textbox id="txt2" value="tabindex-1" tabindex="-1" />
		<textbox id="txt3" value="tabindex2" />
	</div>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val txt1 = ztl$engine.$f("txt1")
    val txt2 = ztl$engine.$f("txt2")
    val txt3 = ztl$engine.$f("txt3")
    runZTL(zscript, () => {
      focus(txt1.$n())
      sendKeys(txt1.$n(), Keys.TAB)
      waitResponse()
      verifyTrue(!"".equals(jq(txt3).css("box-shadow")))
    })
  }
}



