package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

/* B85_ZK_3702Test.java

        Purpose:
                
        Description:
                
        History:
                Wed May 30 18:14:55 CST 2018, Created by klyve

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
@IgnoreBrowsers("ios,android")
class B85_ZK_3702Test extends ZTL4ScalaTestCase {
  @Test
  def test()=  {
    runZTL(() => {
      focus(jq("@combobox").toWidget().$n("real"));
      waitResponse()
      sendKeys(jq("@combobox").toWidget().$n("real"), Keys.SPACE);
      waitResponse()
      verifyTrue(jq(".z-combobox-content").isVisible());
      waitResponse()
      click(jq("body"))
      waitResponse()
      focus(jq("@combobox").toWidget().$n("real"));
      waitResponse()
      sendKeys(jq("@combobox").toWidget().$n("real"), Keys.CONTROL);
      waitResponse()
      verifyFalse(jq(".z-combobox-content").isVisible());
    })
  }
}