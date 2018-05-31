/* B50_2984235Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_2984235Test extends ZTL4ScalaTestCase {
  @Test
  def testpopup() = {
    var zscript =
      """
			<zk>
				<textbox id="tb" tooltip="popup" />
				<combobox id="cb" tooltip="popup"/>
				<popup id="popup"/>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tb = ztl$engine.$f("tb")
    val cb = ztl$engine.$f("cb")
    val popup = ztl$engine.$f("popup")
    runZTL(zscript, () => {
      var tbNode = tb.$n()
      mouseOver(tbNode)
      sleep(1000)
      verifyTrue(popup.exists())
      mouseOut(tbNode)
      mouseOver(cb.$n())
      sleep(1000)
      verifyTrue(popup.exists())
    })
  }
}



