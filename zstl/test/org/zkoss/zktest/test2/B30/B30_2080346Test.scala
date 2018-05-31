/* B30_2080346Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_2080346Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
<vbox>
1. focus combobox by clicking into it
<separator/>
2. type "a", textbox value should be "a". (if the value is "aa", it is wrong)
<separator/>
3. Than ENTER. Onchanging event fired, textbox value should be "aa". (if the value is "a", it is wrong)
</vbox>

<combobox onChanging="copy.value=event.value" autodrop="true">
<comboitem label="aa" />
<comboitem label="aabc" />
<comboitem label="bb" />
<comboitem label="bbde" />
<comboitem label="cc" />
<comboitem label="ccdf" />
</combobox>
<textbox id="copy" readonly="true" />
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val copy = ztl$engine.$f("copy")
    runZTL(zscript, () => {
      var inp = jq("@combobox").toWidget().$n("real")
      focus(inp)
      typeKeys(inp, "a")
      blur(inp)
      waitResponse()
      verifyEquals("a", jq(copy).`val`())
    })
  }
}



