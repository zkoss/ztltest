/* B50_2975748Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_2975748Test extends ZTL4ScalaTestCase {
  @Test
  def testpopup() = {
    var zscript =
      """
			<zk>
			   <button id="btn" popup="popup" onClick="" />
			   <popup id="popup"/>
			</zk>
		"""
    val ztl$engine = engine()
    val btn = ztl$engine.$f("btn")
    val popup = ztl$engine.$f("popup")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyTrue(popup.exists())
    })
  }
}



