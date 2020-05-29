/* B30_1867370Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget

class B30_1867370Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = engine()
    val mybutton = ztl$engine.$f("mybutton")
    runZTL(() => {
      click(mybutton)
      waitResponse()
      verifyTolerant(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth(), 1)
      verifyTolerant(0, jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth(), 1)
      click(jq("@paging").find(".z-paging-next"))
      waitResponse()
      verifyTolerant(1, jq(".z-row").length(), 1)
      verifyTolerant(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth(), 1)
      click(jq("@paging").find(".z-paging-previous"))
      waitResponse()
      verifyTolerant(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth(), 1)
      verifyTolerant(0, jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth(), 1)
      click(mybutton)
      waitResponse()
      verifyNotEquals(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth())
      verifyNotEquals(0, jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth())
      click(jq("@paging").find(".z-paging-next"))
      waitResponse()
      verifyNotEquals(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth())
      click(jq("@paging").find(".z-paging-previous"))
      waitResponse()
      verifyNotEquals(0, jq(".z-row:eq(0) .z-row-inner:eq(1)").outerWidth())
      verifyNotEquals(0, jq(".z-row:eq(1) .z-row-inner:eq(1)").outerWidth())
    })
  }
}



