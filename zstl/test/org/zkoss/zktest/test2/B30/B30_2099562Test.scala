/* B30_2099562Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_2099562Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	If you can see the height of the progressmeter (not only 1px) in Opera, that is correct.
	<progressmeter width="100px" id="pm" value="0"/>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val pm = ztl$engine.$f("pm")
    runZTL(zscript, () => {
      verifyTrue(jq("@progressmeter").outerHeight() >= 16)
    })
  }
}



