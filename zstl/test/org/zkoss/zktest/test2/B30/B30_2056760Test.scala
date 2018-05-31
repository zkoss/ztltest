/* B30_2056760Test.java

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


class B30_2056760Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk>
	Please click the "setWidth 350" button, then the width of each column of the listbox will recalculate.
	<listbox id="listbox" width="250px">
		<listhead sizable="true">
			<listheader label="name" sort="auto" />
			<listheader label="gender" sort="auto" />
		</listhead>
		<listitem>
			<listcell label="Mary" />
			<listcell label="FEMALE" />
		</listitem>
		<listitem>
			<listcell label="John" />
			<listcell label="MALE" />
		</listitem>
		<listitem>
			<listcell label="Jane" />
			<listcell label="FEMALE" />
		</listitem>
		<listitem>
			<listcell label="Henry" />
			<listcell label="MALE" />
		</listitem>
	</listbox>
	<button label="setWidth 350">
		<attribute name="onClick">listbox.setWidth("350px");</attribute>
	</button>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val listbox = ztl$engine.$f("listbox")
    runZTL(zscript, () => {
      verifyEquals("250", jq("@listbox").outerWidth())
      var header = jq("@listheader:eq(0)").width()
      var header1 = jq("@listheader:eq(1)").width()
      var column = jq("@listcell:eq(0)").width()
      var column1 = jq("@listcell:eq(1)").width()
      click(jq("@button"))
      waitResponse()
      var headerx = jq("@listheader:eq(0)").width()
      var header1x = jq("@listheader:eq(1)").width()
      var columnx = jq("@listcell:eq(0)").width()
      var column1x = jq("@listcell:eq(1)").width()
      verifyEquals("350", jq("@listbox").outerWidth())
      verifyEquals(50, headerx - header)
      verifyEquals(50, header1x - header1)
      verifyEquals(50, columnx - column)
      verifyEquals(50, column1x - column1)
    })
  }
}



