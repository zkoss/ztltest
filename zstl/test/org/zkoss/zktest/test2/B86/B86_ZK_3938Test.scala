package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/* B86_ZK_3938.java

        Purpose:
                
        Description:
                
        History:
                Wed Aug 01 17:01:28 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
class B86_ZK_3938Test extends ZTL4ScalaTestCase {
  @Test
  def test()= {
    runZTL(() => {
      evalScript("document.body.style.zoom = '125%'")
      waitResponse()
      verifyTolerant(jq("@listheader").eq(2).offsetLeft(), jq("@listcell").eq(2).offsetLeft(), 1)
      verifyTolerant(jq("@listheader").eq(3).offsetLeft(), jq("@listcell").eq(3).offsetLeft(), 1)
      verifyTolerant(jq("@listheader").eq(4).offsetLeft(), jq("@listcell").eq(4).offsetLeft(), 1)
      evalScript("document.body.style.zoom = '100%'")
      waitResponse()
    })
  }
}
