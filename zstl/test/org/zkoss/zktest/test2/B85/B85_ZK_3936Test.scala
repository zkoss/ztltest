package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/* B85_ZK_3936Test.java

        Purpose:
                
        Description:
                
        History:
                Tue Jun 12 18:56:17 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
class B85_ZK_3936Test extends ZTL4ScalaTestCase {
 @Test
  def test()=  {
    runZTL(() => {
      verifyEquals("60px", jq("$combo1").toWidget.$n("real").eval("style.width"))
    });
 }
}
