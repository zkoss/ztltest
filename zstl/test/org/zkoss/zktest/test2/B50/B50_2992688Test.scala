/* B50_2992688Test.java

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


class B50_2992688Test extends ZTL4ScalaTestCase {
  @Test
  def testdisabled() = {
    var zscript =
      """
			<zk>
			    <combobox id="cb" disabled="true"/> 
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      verifyTrue(jq(cb.$n("real")).is("[disabled=disabled]"))
    })
  }
}



