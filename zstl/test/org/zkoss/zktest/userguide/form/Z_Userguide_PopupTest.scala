/* PopupTest.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.userguide.form

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.IgnoreBrowsers

@IgnoreBrowsers("ios,android")
class Z_Userguide_PopupTest extends ZTL4ScalaTestCase {
  @Test
  def testPopup() = {
    runZTL(() => {
      mouseOver(jq("@image:eq(0)"))
      sleep(1000)
      verifyTrue(jq("$mail").isVisible)
      click(jq("$view").find("@textbox:eq(0)"))
      waitResponse()
      verifyFalse(jq("$mail").isVisible)

      click(jq("@image:eq(1)"))
      waitResponse()
      verifyTrue(jq("$title").isVisible)
    })
  }
}



