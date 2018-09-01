/* B35_2107675Test.java

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


class B35_2107675Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<zk>
	You shall see "Correct 4 Correct 3" below
	<separator bar="true"/>
	<zk switch="${each}" forEach="zk, gwt">
		<zk case="gwt">
	    Correct 3
		</zk>
		<zk case="${each}" forEach="best, zk">
	    Correct 4
		</zk>
		<zk>
	    Error 3
		</zk>
	</zk>
</zk>
		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyContains(jq("@label:eq(1)").text(), "Correct 4")
      verifyContains(jq("@label:eq(2)").text(), "Correct 3")
    })
  }
}



