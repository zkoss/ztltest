/* B36_2806414Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2806414Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
<zk>
Please type some words into the textbox and press "Enter", you should not see any Javascript error on the browser's status bar.
<window  onOK='self.detach()'>
<textbox onChanging=""/>
</window>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      focus(jq("input.z-textbox"))
      sendKeys(jq("input.z-textbox"), "AAA", Keys.ENTER)
      verifyFalse(jq(".z-error").exists())
    })
  }
}



