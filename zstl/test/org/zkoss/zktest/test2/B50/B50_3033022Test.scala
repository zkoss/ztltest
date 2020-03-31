/* B50_3033022Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3033022Test extends ZTL4ScalaTestCase {
  @Test
  def testResize() = {
    val ztl$engine = engine()
    val tb2 = ztl$engine.$f("tb2")
    val tb3 = ztl$engine.$f("tb3")
    val tb4 = ztl$engine.$f("tb4")
    val tb5 = ztl$engine.$f("tb5")
    val tabpanel1 = ztl$engine.$f("tabpanel1")
    val tabpanel2 = ztl$engine.$f("tabpanel2")
    runZTL(() => {
      var hgh = jq(tabpanel1).outerHeight()
      var tabhgh = jq(tabpanel2).outerHeight()
      click(tb2.$n("cls"))
      waitResponse()
      var hgh2 = jq(tabpanel1).outerHeight()
      verifyEquals(hgh2 - hgh, tabhgh)
      hgh = hgh2
      click(tb3.$n("cls"))
      waitResponse()
      hgh2 = jq(tabpanel1).outerHeight()
      verifyEquals(hgh2 - hgh, tabhgh)
      hgh = hgh2
      click(tb4.$n("cls"))
      waitResponse()
      hgh2 = jq(tabpanel1).outerHeight()
      verifyEquals(hgh2 - hgh, tabhgh)
      hgh = hgh2
      click(tb5.$n("cls"))
      waitResponse()
      hgh2 = jq(tabpanel1).outerHeight()
      verifyEquals(hgh2 - hgh, tabhgh)
    })
  }
}



