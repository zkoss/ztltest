/* B36_2861272Test.java

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


class B36_2861272Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	You should see both item "One" and "Three" into the list.
	<listbox rows="1" mold="select">
	<listitem label="One"/>
	<listitem label="Two" visible="false"/>
	<listitem label="Three"/>
	</listbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      verifyEquals(2, jq("select option").length())
      verifyEquals("One", jq("select option:eq(0)").text())
      verifyEquals("Three", jq("select option:eq(1)").text())
    })
  }
}



