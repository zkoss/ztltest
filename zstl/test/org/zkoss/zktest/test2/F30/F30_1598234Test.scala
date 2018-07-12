/* F30_1598234Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.F30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class F30_1598234Test extends ZTL4ScalaTestCase {
  @Test
  def testConstraint() = {
    var zscript =
      """
		<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
			<n:p>[ 1598234 ] strict autocomplete in comboboxes</n:p>
		        <n:p>1. Type a text which not in comboitem.</n:p>
		        <n:p>2. Focus on other place but comboitem, and it should display a error message</n:p>
			<combobox id="cb" onChanging="msg.value = event.value" constraint="strict">
				<comboitem label="Simple and Rich" />
				<comboitem label="Cool!" />
				<comboitem label="Thumbs Up!" />
			</combobox>
			<label id="msg" />
		</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb = ztl$engine.$f("cb")
    val msg = ztl$engine.$f("msg")
    runZTL(zscript, () => {
      verifyFalse(jq(".z-errorbox").exists())
      var inp = cb.$n("real")
      inp.toElement().set("value", "")
      sendKeys(inp, "abc")
      waitResponse()
      blur(inp)
      waitResponse()
      verifyEquals("abc", msg.attr("value"))
      blur(cb)
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



