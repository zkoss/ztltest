/* B30_1997828Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1997828Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window title="Customizable Tooltips" border="normal" width="360px">
	Please click the image, then you should see the popup component.
	<toolbarbutton src="/test2/img/icon_email.png"  popup="any"/>
	<popup id="any" width="300px">
		<vbox>
			ZK simply rich.
			<toolbarbutton label="ZK your killer Web application now!" href="http://www.zkoss.org"/>
		</vbox>
	</popup>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val any = ztl$engine.$f("any")
    runZTL(zscript, () => {
      click(jq("img"))
      waitResponse()
      verifyTrue(jq(".z-popup").exists())
      verifyTrue(jq(".z-popup").isVisible())
    })
  }
}



