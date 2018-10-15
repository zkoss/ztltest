/* B50_3011489Test.java

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


class B50_3011489Test extends ZTL4ScalaTestCase {
  @Test
  def testformat() = {
    var zscript =
      """
			<zk><decimalbox format="##0.00%" value="3.5"/>
			<button label="blur"/></zk>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      `type`(jq("@decimalbox"), "3.5")
      waitResponse()
      verifyEquals("350.00%", jq("@decimalbox ").`val`())
    })
  }
}



