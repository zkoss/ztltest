package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/* B85_ZK_3920.java

        Purpose:
                
        Description:
                
        History:
                Mon Jun 11 16:37:55 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
class B85_ZK_3920Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val lb = jq("@listbox")
      val lbbody = jq(lb.toWidget.$n("body"))
      verScroll(lb, 100)
      waitResponse()
      click(jq("@listitem:contains(item 2-5)"))
      waitResponse()
      verScroll(jq("@listbox"), 0)
      waitResponse()
      click(jq(".z-listgroup-icon").get(1))
      waitResponse()
      verifyFalse(hasVScrollbar(lbbody))
    });
  }
}
