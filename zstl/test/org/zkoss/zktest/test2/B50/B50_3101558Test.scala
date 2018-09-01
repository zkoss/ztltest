/* B50_3101558Test.java

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


class B50_3101558Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
<zk>
 you shall see 5 "35px" widget in the screen ;
 <div id="div">
  <combobox width="35px" />
  <bandbox width="35px" />
  <datebox width="35px" />
  <timebox width="35px" />
  <spinner width="35px" />
 </div>
</zk>
		"""
    val ztl$engine = engine()
    val div = ztl$engine.$f("div")
    runZTL(zscript, () => {
      var w = div.firstChild()
      for (i <- 0 until 5) {
        verifyEquals(35, jq(w).width())
        w = w.nextSibling()
      }
    })
  }
}



