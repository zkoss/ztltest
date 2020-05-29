/* B30_2041674Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_2041674Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk
	xmlns="http://www.zkoss.org/2005/zul"
	xmlns:h="http://www.w3.org/1999/xhtml">
	<window>
		<div>Hover mouse over disabled item, popup menu disappears(This is wrong.)</div>

		<menubar autodrop="true">
			<menu label="Popup Menu">
				<menupopup>
					<menuitem
						label="Hover mouse here..."
						href="http://www.zkoss.org"
						disabled="true" />
					<menuitem
						label="OK Here"
						href="http://www.zkoss.org" />
				</menupopup>
			</menu>
		</menubar>
	</window>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      mouseOver(jq(".z-menu").toWidget().$n("a"));
      waitResponse()
      mouseOver(jq(".z-menuitem:eq(0)"));
      verifyTrue(jq(".z-menupopup").isVisible())
    })
  }
}



