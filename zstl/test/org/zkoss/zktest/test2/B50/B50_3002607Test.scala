/* B50_3002607Test.java

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


class B50_3002607Test extends ZTL4ScalaTestCase {
  @Test
  def testdeleteChar() = {
    var zscript =
      """
			<zk>
				<bandbox id="bb" readonly="true">
					<bandpopup>
						<textbox id="tb" value="test" />
					</bandpopup>
				</bandbox>
			</zk>
		"""
    val ztl$engine = engine()
    val bb = ztl$engine.$f("bb")
    val tb = ztl$engine.$f("tb")
    runZTL(zscript, () => {
      click(bb.$n("btn"))
      waitResponse()
      var before = jq(".z-textbox").`val`()
      focus(tb.$n())
      waitResponse()
      sendKeys(tb.$n(), Keys.END)
      waitResponse()
      sendKeys(tb.$n(), Keys.BACK_SPACE)
      waitResponse()
      verifyNotEquals(jq(".z-textbox").`val`(), before)
    })
  }
}



