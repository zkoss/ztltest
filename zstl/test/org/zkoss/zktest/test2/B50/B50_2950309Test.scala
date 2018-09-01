/* B50_2950309Test.java

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


class B50_2950309Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
			<zk>
				<datebox id="db" readonly="true" />
				<button id="btn" label="disabled" onClick="db.disabled=!db.disabled" />
			</zk>	
			"""
    val ztl$engine = engine()
    val db = ztl$engine.$f("db")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      click(db.$n("btn"))
      waitResponse()
      verifyTrue(isVisible(jq(jq(".z-datebox").toWidget().$n("pp"))))
      click(db.$n("btn"))
      click(btn)
      waitResponse()
      click(db.$n("btn"))
      waitResponse()
      verifyFalse(isVisible(jq(jq(".z-datebox").toWidget().$n("pp"))))
      click(db.$n("btn"))
      click(btn)
      waitResponse()
      click(db.$n("btn"))
      waitResponse()
      verifyTrue(isVisible(jq(jq(".z-datebox").toWidget().$n("pp"))))
    })
  }
}



