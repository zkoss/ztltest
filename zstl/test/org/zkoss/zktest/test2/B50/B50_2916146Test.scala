/* B50_2916146Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2916146Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>
<textbox width="500px" value="Please press Backspace, the browser should do nothing." focus="true" readonly="true"/>
</zk>
			"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      //TODO ,even if keypressnative not works , it still pass the test
      sendKeys(jq("@textbox"), Keys.END)
      sendKeys(jq("@textbox"), Keys.BACK_SPACE)
      waitResponse()
      verifyTrue(jq("@textbox").exists())
      sendKeys(jq("@textbox"), Keys.BACK_SPACE)
      waitResponse()
      verifyTrue(jq("@textbox").exists())
    })
  }
}



