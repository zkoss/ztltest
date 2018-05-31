/* B80_ZK_3233Test.scala

	Purpose:

	Description:

	History:
		Thu, Sep 29, 2016 12:26:45 PM, Created by Sefi

Copyright (C)  Potix Corporation. All Rights Reserved.

This program is distributed under LGPL Version 3.0 in the hope that
it will be useful, but WITHOUT ANY WARRANTY.
*/
package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags;

/**
  *
  * @author Sefi
  */
@Tags(tags = "")
class B80_ZK_3233Test extends ZTL4ScalaTestCase {
  @Test
  def test() = {
    runZTL(() => {
      val inp1 = jq(".z-datebox-input:eq(0)")
      val inp2 = jq(".z-textbox:eq(0)")
      focus(inp1)
      sendKeys(inp1, "a")
      sendKeys(inp1, Keys.TAB)
      waitResponse()
      focus(inp2)
      sendKeys(inp2, "a")
      sendKeys(inp2, Keys.TAB)
      waitResponse()
      verifyEquals(2, jq(".z-errorbox:visible").length())
      click(jq(".z-tab:eq(1)"))
      waitResponse()
      verifyEquals(0, jq(".z-errorbox:visible").length())
      click(jq(".z-tab:eq(0)"))
      waitResponse()
      verifyEquals(2, jq(".z-errorbox:visible").length())
    })
  }
}
