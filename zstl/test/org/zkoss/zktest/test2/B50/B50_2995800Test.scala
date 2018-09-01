/* B50_2995800Test.java

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


class B50_2995800Test extends ZTL4ScalaTestCase {
  @Test
  def testmaximizable() = {
    var zscript =
      """
			<zk>
				<portallayout id="pl" maximizedMode="whole">
					<portalchildren>
						<panel id="panel" border="normal" height="400px" collapsible="true"
							closable="true" maximizable="true" title="Panel">
							<panelchildren>
								<window width="100%" height="100%" />
							</panelchildren>
						</panel>			
					</portalchildren>
				</portallayout>
			</zk>
		"""
    val ztl$engine = engine()
    val pl = ztl$engine.$f("pl")
    val panel = ztl$engine.$f("panel")
    runZTL(zscript, () => {
      var height = jq(pl.$n()).height()
      click(panel.$n("max"))
      verifyEquals(height, jq(pl.$n()).height())
    })
  }
}



