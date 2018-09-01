/* B30_1879511Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1879511Test extends ZTL4ScalaTestCase {
  @Test
  def testErrMsg() = {
    var zscript =
      """
			<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
				<n:p>
					Please type some words into combobox, and then click its popup
					button, and then click the blank of the drop-down list and click
					the outside of the combobox. You should see the error message.
				</n:p>
				<combobox id="cb1" constraint="strict" />
			</zk>
		"""
    val ztl$engine = engine()
    val cb1 = ztl$engine.$f("cb1")
    runZTL(zscript, () => {
      click(cb1.$n("real"))
      sendKeys(cb1.$n("real"), "zk")
      click(jq(cb1.$n("btn")))
      waitResponse()
      click(cb1.$n("pp"))
      waitResponse()
      blur(cb1.$n("real"))
      waitResponse()
      verifyTrue(jq(".z-errorbox").exists())
    })
  }
}



