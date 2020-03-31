/* B30_1737660Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B30_1737660Test extends ZTL4ScalaTestCase {
  @Test
  def testlistboxwidth() = {
    runZTL(() => {
      for (i <- 0 until 2) { // 2 listbox
        var jqlb = jq("@listbox").eq(i)
        var lhr = jqlb.find("@listhead").find("@listheader")
        var lc = jqlb.find("@listitem").find("@listcell")
        for (j <- 0 to 7) { // 7 listhead/listcell
          verifyEquals(lhr.eq(i).outerWidth(), lc.eq(i).outerWidth())
        }
      }
    })
  }
}



