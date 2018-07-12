/* B85_ZK_3914Test.java

        Purpose:

        Description:

        History:
                Fri Mar 30 15:46:59 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.JQuery

class B85_ZK_3914Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      testEmptyMessageWidth(jq(".z-grid-emptybody"))
      testEmptyMessageWidth(jq(".z-listbox-emptybody"))
    })
  }

  def testEmptyMessageWidth(emptyBody: JQuery)=  {
    verifyTolerant(emptyBody.width(), emptyBody.find("td").width(), 2)
  }
}
