/* B30_2086020Test.java

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


class B30_2086020Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
<vbox>
1. focus combobox by clicking into it
<separator/>
2. type "aa", than ENTER. onchanging event should be fired, and textbox
value should be "aa". (if the value is "a", it is wrong)
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
    val ztl$engine = engine()
    val copy = ztl$engine.$f("copy")
    runZTL(zscript, () => {
      var inp = jq("@combobox").toWidget().$n("real")
      focus(jq(inp))
      typeKeys(jq(inp), "aa")
      blur(jq(inp))
      waitResponse()
      verifyEquals("aa", jq(copy).`val`())
    })
  }
}



