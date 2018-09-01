/* B50_3000881Test.java

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


class B50_3000881Test extends ZTL4ScalaTestCase {
  @Test
  def testWidth() = {
    var zscript =
      """
<hbox>
<tabbox>
	<tabs>
		<tab label="tab1" />
		<tab label="tab2" />
		<tab label="tab3" />
	</tabs>
	<tabpanels>
		<tabpanel />
		<tabpanel />
		<tabpanel />
	</tabpanels>
</tabbox>
</hbox>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyFalse(jq("@tabbox").outerWidth() > 5000)
    })
  }
}



