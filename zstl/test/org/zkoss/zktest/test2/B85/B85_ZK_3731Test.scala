package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/* B85_ZK_3731Test.java

        Purpose:
                
        Description:
                
        History:
                Tue Mar 06 5:39 PM:09 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
@Tags(tags = "")
class B85_ZK_3731Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(executor = () => {
      for (index <- 0 to jq("a").length() - 1) {
        click(jq("a").get(index));
        waitResponse();
      }
      var number = getBrowserTabCount()
      verifyEquals(number, 10)
    })
  }
}
