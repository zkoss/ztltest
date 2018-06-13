/* B50_3285610Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3285610Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Inplace editor doesn't remove the border when focus out</li>
		</ol>
	]]></html>

	<textbox id="test1" inplace="true" onFocus="tb.focus();" value="text1"/>
	<textbox id="tb" inplace="true" value="text2"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val test1 = ztl$engine.$f("test1")
    val tb = ztl$engine.$f("tb")
    runZTL(zscript, () => {
      focus(jq(test1))
      sendKeys(test1, Keys.TAB)
      waitResponse()
      verifyTrue("" != jq(".z-textbox").css("box-shadow"))
      if ("1px" == jq("input.z-textbox:eq(0)").css("border-width") || "1" == jq("input.z-textbox:eq(0)").css("border-width"))
        verifyTrue(false)
      else
        verifyTrue(true)
    })
  }
}



