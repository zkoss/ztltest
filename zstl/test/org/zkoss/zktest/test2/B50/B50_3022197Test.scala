/* B50_3022197Test.java

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


class B50_3022197Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
   <html><![CDATA[
	<ul>
	<li>click "set selected"</li>
	<li>select "B" tab</li>
	<li>"BB" tab shall be selected</li>
	</ul>
	]]></html>
	<button label="set selected" onClick="tabB.selected = true;" />
	<tabbox>
		<tabs>
			<tab label="A" />
			<tab label="B" id="b" />
		</tabs>
		<tabpanels>
			<tabpanel>A</tabpanel>
			<tabpanel>
				<tabbox>
					<tabs>
						<tab label="BA" />
						<tab label="BB" id="tabB"/>
					</tabs>
					<tabpanels>
						<tabpanel>BA</tabpanel>
						<tabpanel>BB</tabpanel>
					</tabpanels>
				</tabbox>
			</tabpanel>
		</tabpanels>
	</tabbox>
</zk>

		"""
    val ztl$engine = engine()
    val b = ztl$engine.$f("b")
    val tabB = ztl$engine.$f("tabB")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      click(b)
      waitResponse()
      verifyEquals("BB", jq(".z-tab-selected:eq(1)").text())
    })
  }
}



