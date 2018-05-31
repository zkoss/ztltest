/* B30_1852895Test.java

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
import org.zkoss.ztl.Widget


class B30_1852895Test extends ZTL4ScalaTestCase {
  @Test
  def testItemValue() = {
    var zscript =
      """
				<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
					<n:h4>Select one comboitem from combobox, and then click the "alert" button if the result is not null!</n:h4>
					<combobox id="cb">
						<comboitem label="Simple and Rich" value="1" image="/test2/img/coffee.gif"
						description="The simplest way to make Web applications rich"/>
						<comboitem label="Cool!" value="2" image="/test2/img/corner.gif"
						description="The coolest technology"/>
						<comboitem label="Ajax and RIA" value="3" image="/test2/img/cubfirs.gif"
						description="Rich Internet Application by Ajax"/>
					</combobox>
					<button label="alert" onClick='alert(cb.getSelectedItem().getValue() + "");'/>
				</zk>
			 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      click(jq(jq(".z-combobox").toWidget().$n("btn")))
      waitResponse()
      click(jq(".z-comboitem:eq(0)"))
      waitResponse()
      click(jq(".z-button"))
      waitResponse()
      var result = jq(".z-window-highlighted .z-messagebox").text().trim()
      verifyEquals("1", result)
    })
  }
}



