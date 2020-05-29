/* B30_1825896Test.java

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

class B30_1825896Test extends ZTL4ScalaTestCase {
  @Test
  def testResizeColumn() = {
    runZTL(() => {
      var colWidth = jq(".z-column:eq(3)").width()
      dragdropTo(jq(".z-column:eq(3)"), (colWidth - 2) + ",5", (colWidth / 2) + ",5")
      verifyTrue(jq(".z-row-inner:eq(3)").find(".z-datebox").innerWidth() < jq(".z-column:eq(3)").outerWidth())
    })
  }
}



