package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{JQuery, Tags}

/* B85_ZK_3606.java

        Purpose:
                
        Description:
                
        History:
                Tue Mar 06 6:18 PM:53 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/

@Tags(tags = "")
class B85_ZK_3606Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      val window = jq(".z-window")
      var button = jq("button");
      var test = jq(".z-hlayout").find(".z-label")
      verScrollAbs(window, 0)
      waitResponse()
      click(test)
      waitResponse()
      var popup = jq(".z-popup-open").first()
      waitResponse()
      var popupTop1 = popup.offsetTop()
      verScrollAbs(window, 100)
      waitResponse()
      sleep(500)
      var popupTop2 = popup.offsetTop()
      verifyEquals(100, popupTop1 - popupTop2)
      waitResponse()
      verScrollAbs(window, 0)
      waitResponse()
      click(button)
      waitResponse()
      var noti = jq(".z-notification").first()
      var noti1 = noti.offsetTop();
      verScrollAbs(window, 100)
      waitResponse()
      var noti2 = noti.offsetTop();
      verifyEquals(100, noti1-noti2)
    })
  }
}
