/* B30_2071996Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_2071996Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
<zk>
	Press next page twice to go to the last page
	Then, check if all listitem can be selected (by moving mouse over them and click upon it).
	<zscript>
	String[] data = new String[] {
		"Albert", "Bob", "Candy", "Elva", "Elva2", "Gaby", "Gavin", "Jason",
		"John", "Jean", "Janet", "Jamie", "Jessica", "Peter",
		"Rex", "Richard", "Sam", "Sidney", "Simon", "Sky", "Tony", "Vicky",
		"Winnie", "Wendy", "Zera", "Zenobia" };
	ListModel strset = new SimpleListModel(data);
	</zscript>
	<listbox id="search" model="&#36;{strset}" />
	<paging onCreate='search.setMold("paging");search.paginal=self;search.pageSize=10;' />
</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val search = ztl$engine.$f("search")
    runZTL(zscript, () => {
      click(jq("[name=" + jq("@paging").attr("id") + "-next]"));
      waitResponse()
      click(jq("[name=" + jq("@paging").attr("id") + "-next]"));
      waitResponse()
      for (i <- 1 until 6) {
        click(jq("@listitem:eq(" + i + ")")); waitResponse()
        verifyTrue(jq("@listitem:eq(" + i + ")").hasClass("z-listitem-selected"))
      }
    })
  }
}


