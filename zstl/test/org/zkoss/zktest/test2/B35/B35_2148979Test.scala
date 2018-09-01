/* B35_2148979Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B35

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B35_2148979Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window border="normal" width="350px" sizable="true" minimizable="true"
	maximizable="true" closable="true">
	<caption image="/test2/img/inet.png"
		label="You should see three tool icons here" />
</window>

		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyEquals(3, jq(".z-window-icon").length())
      verifyTrue(jq(jq("@window").toWidget().$n("max")).isVisible())
      verifyTrue(jq(jq("@window").toWidget().$n("min")).isVisible())
      verifyTrue(jq(jq("@window").toWidget().$n("close")).isVisible())
    })
  }
}



