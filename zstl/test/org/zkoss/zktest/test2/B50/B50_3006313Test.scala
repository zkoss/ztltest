/* B50_3006313Test.java

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


class B50_3006313Test extends ZTL4ScalaTestCase {
  @Test
  def testSliderGetCurpos() = {
    var zscript =
      """
			<zk xmlns:w="http://www.zkoss.org/2005/zk/client">
				<slider id="sld" curpos="50" />
				<button id="btn1" label="Show getCurpos()" 
					onClick='ib1.value = sld.curpos'
					w:onClick='this.$f("ib2").setValue(this.$f("sld").getCurpos());' />
				<intbox id="ib1" value="0"/>
				<intbox id="ib2" value="0"/>
			</zk>
		"""
    val ztl$engine = engine()
    val sld = ztl$engine.$f("sld")
    val btn1 = ztl$engine.$f("btn1")
    val ib1 = ztl$engine.$f("ib1")
    val ib2 = ztl$engine.$f("ib2")
    runZTL(zscript, () => {
      dragdropTo(sld.$n("btn"), "1,1", "55,1")
      waitResponse()
      click(btn1)
      waitResponse()
      verifyTolerant(75, parseInt(jq(ib1).`val`()), 2)
      verifyTolerant(75, parseInt(jq(ib2).`val`()), 2)
    })
  }
}



