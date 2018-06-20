package org.zkoss.zktest.test2.B85

import org.zkoss.zstl.ZTL4ScalaTestCase

/* B85_ZK_3925Test.java

        Purpose:
                
        Description:
                
        History:
                Wed Jun 20 09:36:16 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/ class B85_ZK_3925Test extends ZTL4ScalaTestCase {
  def test(): Unit = {
    runZTL(() => {
      click(jq("@panel").toWidget.$n("max"))
      waitResponse()
      click(jq("@button")) 
      // After clicking the button, click the maximized tag as soon as possible 
      click(jq("@panel").toWidget.$n("max"))
      waitResponse()
      click(jq("@panel").toWidget.$n("max"))
      verifyEquals(400, jq("@panel").width())
      verifyEquals(300, jq("@panel").height())
    })
  }
}
