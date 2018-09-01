/* B50_3259998Test.java

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


class B50_3259998Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	<html><![CDATA[
		<ol>
			<li>Close tab2 shall not cause js error.</li>
		</ol>
	]]></html>
	<tabbox width="500px">
		<tabs>
			<tab label="Tab 1" closable="true" />
			<tab label="Tab 2" closable="true" selected="true"/>
		</tabs>
		<tabpanels>
			<tabpanel>This is panel 1</tabpanel>
			<tabpanel>This is panel 2</tabpanel>
		</tabpanels>
	</tabbox>
</zk>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      click(jq(".z-tab:eq(1)").toWidget().$n("cls"))
      waitResponse()
      verifyFalse(jq(".z-error").exists())
    })
  }
}



