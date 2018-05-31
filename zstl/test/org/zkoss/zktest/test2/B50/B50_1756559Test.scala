/* B50_1756559Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_1756559Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<window title="mouseless dropdown test" border="normal">
<vbox>
<label value="1. Use keyboard arrows (NOT MOUSE) to change dropdown selection"/>
<label value="2. Press ENTER to see current selection"/>
<label value="3. Click the arrow to drop down the list, and then repeat 2 again to see if it is correct"/>
<listbox id="lb" mold="select" focus="true">
<listitem label="option1"/>
<listitem label="option2"/>
<listitem label="option3"/>
</listbox>
<hbox>Result is: <label id="result"/></hbox>
</vbox>
<attribute name="onCreate">
lb.setSelectedIndex(0);
</attribute>
<attribute name="onOK">
result.value = lb.getSelectedItem().getLabel();
</attribute>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lb = ztl$engine.$f("lb")
    val result = ztl$engine.$f("result")
    runZTL(zscript, () => {
      sendKeys(jq("select"), Keys.DOWN)
      sendKeys(jq("select"), Keys.ENTER)
      waitResponse()
      verifyEquals("option2", jq(result).text())
      select(lb, "option1")
      sendKeys(jq("select"), Keys.ENTER)
      waitResponse()
      verifyEquals("option1", jq(result).text())
    })
  }
}



