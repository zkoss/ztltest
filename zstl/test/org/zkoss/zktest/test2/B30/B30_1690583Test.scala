/* B30_1690583Test.java

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

class B30_1690583Test extends ZTL4ScalaTestCase {
  @Test
  def testVisible() = {
    var zscript =
      """
			<vbox>
				<hbox>
					<popup width="300px" id="help">
					Help is coming.
					</popup>
					<textbox id="t" visible="false"/>
					<label tooltip="help" value="Help" />
				</hbox>
				align
				<button label="toggle" id="btn" onClick="t.visible = !t.visible"/>
			</vbox> 
		"""
    val ztl$engine = engine()
    val help = ztl$engine.$f("help")
    val t = ztl$engine.$f("t")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      // Test visible
      if (help.exists()) {
        verifyFalse(isVisible(help))
      }
      verifyFalse(isVisible(t))
      click(btn)
      waitResponse()
      if (help.exists()) {
        verifyFalse(isVisible(help))
      }
      verifyTrue(isVisible(t))
      // Test invisible
      click(btn)
      waitResponse()
      if (help.exists()) {
        verifyFalse(isVisible(help))
      }
      verifyFalse(isVisible(t))
    })
  }
}



