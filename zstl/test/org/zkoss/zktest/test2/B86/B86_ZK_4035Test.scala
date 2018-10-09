package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/* B86_ZK_4035.java

        Purpose:
                
        Description:
                
        History:
                Thu Aug 23 14:18:16 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
class B86_ZK_4035Test extends ZTL4ScalaTestCase {

  @Test
  def test()= {
    runZTL(() => {
      windowResizeTo(500,500);
      waitResponse();
      verifyTolerant(jq("$s1").width() + jq("$s2").width() + 10, jq("body").width(), 5);
    })
  }
}
