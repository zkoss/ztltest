package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/* B85_ZK_3833Test.java

        Purpose:
                
        Description:
                
        History:
                Mon Mar 12 4:53 PM:47 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
class B85_ZK_3833Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      click(jq(".z-datebox-button:eq(0)"))
      waitResponse()
      verifyEquals(jq(".z-calendar-selected:eq(0)").text(), "1")
      waitResponse()
      click(jq("body"))
      waitResponse()
      click(jq(".z-datebox-button:eq(1)"))
      waitResponse()
      verifyEquals(jq(".z-calendar-selected:eq(0)").text(), "1")
      waitResponse()
    })
  }
}
