/* B36_2837303Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2837303Test extends ZTL4ScalaTestCase {
  @Test
  def testheight() = {
    var zscript =
      """
			<zk>
			You should see the height of the progressmeter is 10px height.
			<progressmeter height="10px"  width="95%" value="50" />
			For example, The bottom progressmeter is bigger than 10px height.
			<progressmeter width="95%" value="50" />
			</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals(10, jq("@progressmeter:eq(0)").outerHeight())
      verifyTrue(jq("@progressmeter:eq(1)").outerHeight() > 10)
    })
  }
}



