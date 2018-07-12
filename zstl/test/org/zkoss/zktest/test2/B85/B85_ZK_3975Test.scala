package org.zkoss.zktest.test2.B85

import org.zkoss.zstl.ZTL4ScalaTestCase

/* B85_ZK_3975Test.java

        Purpose:
                
        Description:
                
        History:
                Wed Jul 04 15:47:04 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/ class B85_ZK_3975Test extends ZTL4ScalaTestCase {
  def test()=  {
    runZTL(() => {
      var listbox = jq("@listbox")
      verScroll(listbox, 1)
      waitResponse()
      click(jq(".z-listgroup-icon-open").eq(2))
      waitResponse()
      var lastListgroup = jq(".z-listgroup").eq(2);
      verifyTolerant(listbox.height() + listbox.offsetTop(), lastListgroup.offsetTop() + lastListgroup.height(), 1)
    })
  }
}
