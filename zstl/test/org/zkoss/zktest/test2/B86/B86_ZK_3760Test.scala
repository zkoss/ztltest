package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

/* B86_ZK_3760Test.java

        Purpose:
                
        Description:
                
        History:
                Tue Jul 31 15:27:20 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/ class B86_ZK_3760Test extends ZTL4ScalaTestCase {

  @Test
  def test()= {
    runZTL(() => {
      var contact = jq("$contact");
      var settings = jq("$settings");
      var level0 = jq("$level0");
      var level1 = jq("$level1");
      var level2 = jq("$level2");
      verScrollAbs(jq("@center"), 500);
      waitResponse()
      click(contact)
      waitResponse()
      verifyTolerant(contact.height() + contact.offsetTop(), level1.offsetTop(), 10)
      click(settings)
      waitResponse()
      verifyTolerant(level1.height() + level1.offsetTop(), level2.offsetTop(), 10)
      
    })
  }
}
