/* B30_2026493Test.java

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
import org.zkoss.ztl.unit.Widget


class B30_2026493Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<zk xmlns:n="http://www.zkoss.org/2005/zk/native">
	<n:p>If you see the white space(about one item height) between the "9-1" item and the paging, it is wrong.  </n:p>
	<window>
	
		<zscript>
		List items = new org.zkoss.zktest.test2.BigList(20); //a big list of Integer
		</zscript>
		<listbox mold="paging" pageSize="10" vflex="true">
			<listitem forEach="&#36;{items}">
			<listcell label="&#36;{each}-1"/>
			<listcell label="&#36;{each}-2"/>
			<listcell label="&#36;{each}-3"/>
			<listcell label="&#36;{each}-4"/>
			</listitem>
		</listbox>
	</window>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      var body = jq("tbody:eq(0)").outerHeight()
      var paging = jq("div.z-paging").parent().outerHeight()
      var listbox = jq("div.z-listbox").outerHeight()
      verifyTolerant(listbox, body + paging, 2)
    })
  }
}



