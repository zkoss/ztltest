/* B85_ZK_3850Test.java

        Purpose:

        Description:

        History:
                Fri Mar 23 16:35:33 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B85_ZK_3850Test extends ZTL4ScalaTestCase {

  @Test
  def test() = {
    runZTL(() => {
      val tr3 = jq("@row").eq(2)
      val height = tr3.height

      click(jq("@button"))
      waitResponse(true)

      verifyEquals(height, tr3.height())
    })
  }
}
