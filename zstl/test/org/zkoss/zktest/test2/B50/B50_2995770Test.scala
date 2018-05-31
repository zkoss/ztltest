/* B50_2995770Test.java

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
import org.zkoss.ztl.Widget


class B50_2995770Test extends ZTL4ScalaTestCase {
  @Test
  def testChangeIcon() = {
    var zscript =
      """
<zk>
<window title="Region Disappears" border="normal">
	<tabbox>
		<tabs>
			<tab id="t1" label="tab 1" />
			<tab id="t2" label="tab 2" />
		</tabs>
		<tabpanels>
			<tabpanel>
				<borderlayout height="500px">
					<center>
						<label value="center" />
					</center>
					<east id="east" size="200px" collapsible="true" open="false">
						<label value="east" />
					</east>
				</borderlayout>
			</tabpanel>
			<tabpanel>
				<button id="btn" label="Go" onClick="east.open = true" />
			</tabpanel>
		</tabpanels>
	</tabbox>
</window>
</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val t1 = ztl$engine.$f("t1")
    val t2 = ztl$engine.$f("t2")
    val east = ztl$engine.$f("east")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      click(t2)
      waitResponse()
      click(btn)
      waitResponse()
      click(t1)
      waitResponse()
      verifyEquals(200, jq(east.$n("real")).outerWidth())
    })
  }
}



