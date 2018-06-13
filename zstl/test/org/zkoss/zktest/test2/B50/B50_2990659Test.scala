/* B50_2990659Test.java

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


class B50_2990659Test extends ZTL4ScalaTestCase {
  @Test
  def testFormat() = {
    var zscript =
      """
		<decimalbox id="db" format="R ##,###,###,###.00"/>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val db = ztl$engine.$f("db")
    runZTL(zscript, () => {
      sendKeys(db, "1111")
      waitResponse();
      blur(db)
      verifyEquals("R 1,111.00", jq(db).`val`());
    })
  }
}



