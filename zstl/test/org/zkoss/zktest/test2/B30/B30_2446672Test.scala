/* B30_2446672Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2446672Test extends ZTL4ScalaTestCase {
  @Test
  def testcombobox() = {
    var zscript =
      """
			<zk>
			Please click on the image, you should not see any dialog.
			<toolbarbutton id="tbb" disabled="true" image="/test2/img/defender.gif"
							onClick='alert("Defender")' />
			</zk>
		"""
    val ztl$engine = engine()
    val tbb = ztl$engine.$f("tbb")
    runZTL(zscript, () => {
      click(tbb)
      waitResponse()
      verifyFalse(jq(".z-window-highlighted").exists())
    })
  }
}



