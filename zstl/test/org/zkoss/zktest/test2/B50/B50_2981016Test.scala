/* B50_2981016Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2981016Test extends ZTL4ScalaTestCase {
  @Test
  def testwidth() = {
    var zscript =
      """
			<zk>
				<combobox id="cb" width="80px" />
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val cb = ztl$engine.$f("cb")
    runZTL(zscript, () => {
      var inpWidth = Integer.valueOf(cb.$n("real").attr("offsetWidth"))
      var btnWidth = Integer.valueOf(cb.$n("btn").attr("offsetWidth"));
      verifyTolerant(inpWidth + btnWidth, 80, 2)
    })
  }
}



