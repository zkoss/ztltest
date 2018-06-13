/* B50_2919175Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2919175Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
1. select Cool!
<separator/>
2. type abc into combobox
<separator/>
3. tab away
<separator/>
4. It should not complain "This field should not be empty ...."
<combobox constraint="no empty">
<comboitem label="Simple and Rich" />
<comboitem label="Cool!" />
<comboitem label="Thumbs Up!" />
</combobox>
</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      var combobox = jq(".z-combobox").toWidget()
      click(combobox.$n("btn"))
      waitResponse()
      click(jq("@comboitem[label=\"Cool!\"]"))
      waitResponse()
      typeKeys(combobox.$n("real"), "abc")
      waitResponse()
      blur(combobox)
      waitResponse()
      verifyFalse(jq(".z-errorbox").exists())
    })
  }
}



