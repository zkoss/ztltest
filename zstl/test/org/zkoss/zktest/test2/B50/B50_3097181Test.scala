/* B50_3097181Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3097181Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			
<zk>
	<label multiline="true">
		<attribute name="value"><![CDATA[
			A colorbox in menu doestn't work with menubar autodrop="true"
			
			How to test:
			1. Mouse over on menubar will auto drop menubar
			2. Move mouse to Color Picker will popup color picker
			3. move to color picker and mouse over on a color
			4. when mouse over a color, if color picker close, it's error
			]]></attribute>
	</label>
	<menubar id="menubar" width="100%" autodrop="true">
		<menu image="/img/Centigrade-Widget-Icons/Spyglass-16x16.png">
			<menupopup>
				<menu label="Color Picker" content="#color=#184dc6" />
			</menupopup>
		</menu>
	</menubar>
</zk>

		"""
    val ztl$engine = engine()
    val menubar = ztl$engine.$f("menubar")
    runZTL(zscript, () => {
      mouseOver(jq(".z-menu:eq(0)").toWidget().$n("a"))
      waitResponse()
      mouseOver(jq(".z-menu:eq(1)").toWidget().$n("a"))
      waitResponse()
      verifyTrue(isVisible(jq(".z-colorpalette")))
      mouseOver(jq(".z-colorpalette-color:eq(8)"))
      verifyTrue(isVisible(jq(".z-colorpalette")))
      mouseOver(jq(".z-colorpalette-color:eq(18)"))
      verifyTrue(isVisible(jq(".z-colorpalette")))
      mouseOver(jq(".z-colorpalette-color:eq(28)"))
      verifyTrue(isVisible(jq(".z-colorpalette")))
    })
  }
}



