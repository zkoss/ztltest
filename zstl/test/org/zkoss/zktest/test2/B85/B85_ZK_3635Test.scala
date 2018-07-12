/* B85_ZK_3635Test.java

        Purpose:

        Description:

        History:
                Fri Mar 30 17:16:45 CST 2018, Created by charlesqiu

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B85

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase

class B85_ZK_3635Test extends ZTL4ScalaTestCase {

  @Test
  def test()=  {
    runZTL(() => {
      click(jq(".z-bandbox-button"))
      waitResponse(true)

      click(jq(".z-textbox").eq(0))
      waitResponse(true)

      pressTab()
      pressTab()

      verifyTrue(jq(".z-bandpopup").exists())
      verifyTrue(jq(".z-textbox").eq(1).is(":focus"))
    })
  }

  def pressTab()=  {
    keyPressNative("9")
    waitResponse(true)
  }
}
