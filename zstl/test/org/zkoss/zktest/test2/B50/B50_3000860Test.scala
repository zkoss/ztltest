/* B50_3000860Test.java

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


class B50_3000860Test extends ZTL4ScalaTestCase {
  @Test
  def testTabHeight() = {
    var zscript =
      """
<tabbox>
<tabs>
	<tab id="tab1"/>
	<tab label="tab2"/>
</tabs>
<tabpanels>
	<tabpanel/>
</tabpanels>
</tabbox>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tab1 = ztl$engine.$f("tab1")
    runZTL(zscript, () => {
      verifyTrue(jq("$tab1").outerHeight() > 16)
    })
  }
}



