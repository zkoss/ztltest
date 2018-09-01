/* B50_2942150Test.java

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
import org.zkoss.ztl.unit.Widget


class B50_2942150Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<window title="" border="normal">
						Please click the combobox in IE, the dropdown list can't be shown.
					<combobox id="cb" disabled="true" readonly="true">
						<comboitem label="A"></comboitem>
						<comboitem label="B"></comboitem>
						<comboitem label="C"></comboitem>
						<comboitem label="D"></comboitem>
					</combobox>
				</window>
			"""
    val ztl$engine = engine()
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      click(cb.$n("btn"));
      verifyFalse(jq(jq(".z-combobox").toWidget().$n("pp")).isVisible())
    })
  }
}



