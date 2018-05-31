/* B30_1979239Test.java

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
import org.zkoss.ztl.Widget


class B30_1979239Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window>
	The Tooltip function should work with a Menupopup/Menuitem
<menubar id="menubar" autodrop="true">
<menu label="Wiki">
<menupopup>
<menuitem tooltip="any" label="test"/>
</menupopup>
</menu>
</menubar>
<popup id="any" width="300px">
<vbox>
i am a Tooltip!.
</vbox>
</popup>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val menubar = ztl$engine.$f("menubar")
    val any = ztl$engine.$f("any")
    runZTL(zscript, () => {
      mouseOver(jq(".z-menu").toWidget().$n("a"));
      sleep(500)
      mouseOver(jq(".z-menuitem"));
      sleep(2000)
      verifyTrue(jq(".z-popup").exists())
      verifyTrue(jq(".z-popup").isVisible())
    })
  }
}



