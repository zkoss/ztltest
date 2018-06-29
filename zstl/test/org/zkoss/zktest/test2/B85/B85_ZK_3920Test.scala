package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

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
      var lbbody = jq(jq("@listbox").toWidget().$n("body"));
      var fa = jq(".z-focus-a");
      verScrollAbs(lbbody, 100);
      waitResponse();
      click(jq("@listitem:eq(4)"));
      waitResponse();
      verScrollAbs(lbbody, -100);
      waitResponse();
      click(jq(".z-listgroup-icon").get(1));
      waitResponse();
      verifyTrue(lbbody.height() - fa.height() - fa.offsetTop() > 0);
    });
  }
}
