package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/* B86_ZK_4044Test.java

        Purpose:
                
        Description:
                Fri Aug 31 10:42:24 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
class B86_ZK_4044Test extends ZTL4ScalaTestCase {
                
  @Test
  def test(): Unit =  {
    runZTL(() => {
      verifyEquals("The width of listhead-bar at zoom 100% should bb same as scrollbar width",
            getEval("jq.scrollbarWidth()"), jq(jq("@listhead").toWidget.$n("bar")).outerWidth())
    })
  }

}
