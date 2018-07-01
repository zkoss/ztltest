/* B36_2778524Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36


import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2778524Test extends ZTL4ScalaTestCase {
  @Test
  def testformat() = {
    var zscript =
      """
			<zk>
				<vbox>
					Choice date at the datebox, it should be ok (the year should not always 1999). 
					<datebox id="db1" format="dd.MM.yyyy" />
					Choice date at the datebox, it should not show any error.
					<datebox id="db2" format="dd.MM.yyyy" lenient="false" />
				</vbox>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val db1 = ztl$engine.$f("db1")
    val db2 = ztl$engine.$f("db2")
    runZTL(zscript, () => {
      click(db1.$n("btn"))
      waitResponse()
      click(jq(db1.$n("pp")).find("@calendar").find("td:eq(12)"))
      verifyNotContains(jq(db1.$n("real")).`val`(), "1999")
      click(db2.$n("btn"))
      waitResponse()
      click(jq(db2.$n("pp")).find("@calendar").find("td:eq(12)"))
      waitResponse()
      blur(db2.$n("real"))
      verifyFalse(jq("div.z-errorbox").exists())
    })
  }
}



