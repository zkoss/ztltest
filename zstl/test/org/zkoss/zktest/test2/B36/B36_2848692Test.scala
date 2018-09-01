/* B36_2848692Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2848692Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
0: Use IE
<separator/>
1.Please select the first item from the combobox, and then click the OK button.
<separator/>
2.You should see the result is "CMB selected = 0"
<combobox id="cmb">
<comboitem label='Valor1  "'/>
</combobox>
<button id="ok" label="OK" onClick='alert("CMB selected = "
+ cmb.getSelectedIndex())'/>
</zk>

		"""
    val ztl$engine = engine()
    val cmb = ztl$engine.$f("cmb")
    val ok = ztl$engine.$f("ok")
    runZTL(zscript, () => {
      click(jq(jq(".z-combobox").toWidget().$n("btn")))
      waitResponse()
      click(jq(".z-comboitem:eq(0)"))
      waitResponse()
      click(jq("@button"))
      waitResponse()
      verifyEquals("CMB selected = 0", getAlertMessage())
    })
  }
}



