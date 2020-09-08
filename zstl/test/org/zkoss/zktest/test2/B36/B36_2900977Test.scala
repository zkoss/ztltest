/* B36_2900977Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2900977Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = engine()
    val grid1 = ztl$engine.$f("grid1")
    val rows = ztl$engine.$f("rows")
    runZTL(() => {
      click(jq("@button"))
      waitResponse()
      click(jq("@button"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



