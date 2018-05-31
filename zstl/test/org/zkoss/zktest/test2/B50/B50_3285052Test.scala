/* B50_3285052Test.java

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
import org.zkoss.ztl.Widget


class B50_3285052Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	<html><![CDATA[
		<ol>
			<li>Select tab 3.</li>
			<li>Remove tab 1, tab 2.</li>
			<li>Select tab 5. If you see two Tabpanels, it is a bug.</li>
		</ol>
	]]></html>
	<tabbox width="500px">
		<tabs>
			<tab label="Tab 1" closable="true" />
			<tab label="Tab 2" closable="true" />
			<tab label="Tab 3" closable="true" />
			<tab label="Tab 4" closable="true" />
			<tab label="Tab 5" closable="true" />
			<tab label="Tab 6" closable="true" />
		</tabs>
		<tabpanels>
			<tabpanel>This is panel 1</tabpanel>
			<tabpanel>This is panel 2</tabpanel>
			<tabpanel>This is panel 3</tabpanel>
			<tabpanel>This is panel 4</tabpanel>
			<tabpanel>This is panel 5</tabpanel>
			<tabpanel>This is panel 6</tabpanel>
		</tabpanels>
	</tabbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      click(jq("@tab[label=\"Tab 3\"]"));
      waitResponse()
      click(jq(".z-tab:eq(0)").toWidget().$n("cls"));
      waitResponse()
      click(jq(".z-tab:eq(0)").toWidget().$n("cls"));
      waitResponse()
      click(jq("@tab[label=\"Tab 5\"]"));
      waitResponse()
      verifyEquals("This is panel 5", jq("@tabpanel:visible").text())
    })
  }
}



