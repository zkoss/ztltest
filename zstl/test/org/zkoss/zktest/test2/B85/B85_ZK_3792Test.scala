package org.zkoss.zktest.test2.B85
/* B85_ZK_3792Test.java

        Purpose:

        Description:

        History:
                Thu May 31 11:09:24 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase


class B85_ZK_3792Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      var datebox = jq("@datebox").toWidget.$n("real")
      sendKeys(datebox, "3:00 am")
      waitResponse()
      click(jq("body"))
      waitResponse()
      verifyEquals("03:00 AM", jq(datebox).`val`())
    })
  }
}