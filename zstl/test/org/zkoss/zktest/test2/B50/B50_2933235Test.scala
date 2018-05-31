/* B50_2933235Test.java

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
import org.zkoss.ztl.Widget


class B50_2933235Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<window title="Hello World!!" border="normal" width="400px">

    <combobox id="contentCbx" rows="1" cols="1" readonly="true" width="50px">
        <comboitem label="AAAAAAAAAAAAAAAAAAAAAAAAAAAAA" />
        <comboitem label="BBBBBBBBBBBBBBB" />
        <comboitem label="CBBB" />
    </combobox>

    <button label="Click me to change width that it should work.">
        <attribute name="onClick">
            contentCbx.setWidth("200px");
        </attribute>
    </button>
</window>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val contentCbx = ztl$engine.$f("contentCbx")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyEquals("200px", jq("$contentCbx").css("width"))
    })
  }
}



