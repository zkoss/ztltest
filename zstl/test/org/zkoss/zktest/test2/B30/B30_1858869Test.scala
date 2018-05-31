/* B30_1858869Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1858869Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window id="w" title="Test of textbox with onOK">
	<textbox id="test" onOK="test()"/>
	<zscript>
void test() {
	new Label(test.getValue()).setParent(w);
}
	</zscript>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val w = ztl$engine.$f("w")
    val test = ztl$engine.$f("test")
    runZTL(zscript, () => {
      verifyEquals(0, jq(".z-label").length())
      typeKeys(jq("$test"), "I am test string")
      focus(jq("$test"))
      sendKeys(jq("$test"), Keys.ENTER)
      waitResponse()
      verifyEquals("I am test string", jq(".z-label").text())
    })
  }
}



