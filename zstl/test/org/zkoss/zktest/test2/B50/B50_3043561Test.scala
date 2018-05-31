/* B50_3043561Test.java

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
import org.zkoss.ztl.Widget


class B50_3043561Test extends ZTL4ScalaTestCase {
  @Test
  def testFormat() = {
    var zscript =
      """
<decimalbox format="######.##" value="20.0100002288818359375"/>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals(jq("@decimalbox").`val`(), "20.01")
    })
  }
}



