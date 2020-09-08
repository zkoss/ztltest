/* B30_2026493Test.java

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

class B30_2026493Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    val ztl$engine = engine()
    runZTL(() => {
      var body = jq("tbody:eq(0)").outerHeight()
      var paging = jq(".z-paging").parent().outerHeight()
      var listbox = jq("div.z-listbox").outerHeight()
      verifyTolerant(listbox, body + paging, 2)
    })
  }
}



