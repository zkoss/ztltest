/* B36_2660443Test.java

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
import org.zkoss.ztl.Widget


class B36_2660443Test extends ZTL4ScalaTestCase {
  @Test
  def testpopup() = {
    var zscript =
      """
			<zk>
				<toolbarbutton id="tb" popup="popup" label="Click Me without error, that is correct!(IE only)"/>
				<menupopup id="popup">
				</menupopup>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tb = ztl$engine.$f("tb")
    val popup = ztl$engine.$f("popup")
    runZTL(zscript, () => {
      click(tb)
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



