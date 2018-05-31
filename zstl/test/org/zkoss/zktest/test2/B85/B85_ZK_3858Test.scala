/* B85_ZK_3858.java

        Purpose:

        Description:

        History:
                Wed Mar 21 14:32:59 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B85_ZK_3858Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      click(jq(".z-button"))
      waitResponse(true)
      verifyEquals(jq(".z-north-body > div").width(), jq(".z-center-body > div").width())
    })
  }
}
