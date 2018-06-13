/* B50_2948193Test.java

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


class B50_2948193Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					Please click invalidate button, and it will not happen js error.
					<button id="btn" label="invalidate" onClick="center.invalidate();"/>
					<borderlayout width="100%" height="100%">
						<center id="center" >
							<listbox vflex="true" />
						</center>
					</borderlayout>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn = ztl$engine.$f("btn")
    val center = ztl$engine.$f("center")
    runZTL(zscript, () => {
      click(btn)
      waitResponse()
      verifyFalse(jq(".z-error").exists());
    })
  }
}



