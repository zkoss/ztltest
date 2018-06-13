/* B50_2926718Test.java

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


class B50_2926718Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>You should see "$123.3" in the decimalbox: <decimalbox format="$###.##" value="123.30" width="150px" /></zk>			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals("$123.3", jq("@decimalbox").`val`());
    })
  }
}



