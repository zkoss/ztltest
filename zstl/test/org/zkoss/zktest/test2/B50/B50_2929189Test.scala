/* B50_2929189Test.java

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


class B50_2929189Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
<zk>

1.Click this <button label="Show Tabbox">
<attribute name="onClick">
mydiv.setVisible(true);
</attribute>
</button>
, after click, it should display a tabbox below, if there is no tabbox, it's wrong
<separator height="20px"/>
<div id="mydiv" width="200px" height="200px" visible="false">
<tabbox tabscroll="false">
	<tabs>
		<tab label="tab1" />
		<tab label="tab2" />
	</tabs>
	<tabpanels>
		<tabpanel>tabpanel1</tabpanel>
		<tabpanel>tabpanel2</tabpanel>
	</tabpanels>
</tabbox>
</div>
</zk>
			"""
    val ztl$engine = engine()
    val mydiv = ztl$engine.$f("mydiv")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyTrue(jq(".z-tabbox").exists())
    })
  }
}



