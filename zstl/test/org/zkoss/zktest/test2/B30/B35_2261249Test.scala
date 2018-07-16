/* B35_2261249Test.java

  Purpose:

  Description:

  History:
    May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B35_2261249Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    runZTL(() => {
        var items = jq(".z-menuitem:visible")
        for (j <- 0 until 3) {
          mouseOver(jq("@column").eq(0))
          waitResponse()
          click(jq(".z-column").toWidget.$n("btn"))
          waitResponse()
          click(items.eq(j))
          waitResponse()
        }
        verifyFalse(jq(".z-window-modal").exists())
    })
  }
}