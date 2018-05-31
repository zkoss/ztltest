/* B36_2788618Test.java

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
import org.zkoss.ztl.Widget


class B36_2788618Test extends ZTL4ScalaTestCase {
  @Test
  def testconstraint() = {
    var zscript =
      """
			<zk>
			Please selet today, and then it should not appear a warning box.
			<datebox constraint="no future" id="db"/>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val db = ztl$engine.$f("db")
    runZTL(zscript, () => {
      click(db.$n("btn"))
      waitResponse()
      click(jq("td.z-calendar-selected"))
      waitResponse()
      blur(db.$n("real"))
      waitResponse()
      verifyFalse(jq(".z-errorbox").exists())
    })
  }
}



