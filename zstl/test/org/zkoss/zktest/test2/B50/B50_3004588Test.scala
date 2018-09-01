/* B50_3004588Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_3004588Test extends ZTL4ScalaTestCase {
  @Test
  def testmaximized() = {
    var zscript =
      """
			<zk>
				<portallayout id="pl" width="500px" height="500px" maximizedMode="whole">
					<portalchildren width="50%" height="100%" >
						<panel id="panel" border="normal" title="test" height="300px" maximizable="true">
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
      click(panel.$n("max"))
      verifyTolerant(jq(pl).height(), jq(panel).height(), 5)
    })
  }
}



