package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.By
import org.openqa.selenium.Keys

/* B85_ZK_3626Test.java

        Purpose:
                
        Description:
                
        History:
                Wed Mar 07 6:47 PM:14 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
class B85_ZK_3626Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      evalScript("document.body.style.zoom = '1.5'")
      waitResponse()
      for (i <- 1 to 8) {
        evalScript(jq(".z-menubar-right") + ".click()")
        evalScript(jq(".z-tabbox-right-scroll") + ".click()")
        evalScript(jq(".z-tabbox-down-scroll") + ".click()")
        waitResponse()
      }
      click(jq(".z-button"))
      waitResponse()
      val result = getZKLog.split("\n")
      for (i <- 0 to 2) {
        verifyEquals("true", result(i))
      }
      evalScript("document.body.style.zoom = '1'")
    })
  }
}
