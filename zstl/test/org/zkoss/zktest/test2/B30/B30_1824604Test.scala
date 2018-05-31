/* B30_1824604Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1824604Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			

<zk>
        1.click paging to 2rd page..
2.click sort twice, grid shouldn't become empty.
	<separator/>
	<zscript>
		import org.zkoss.zul.*;
		import java.util.*;
		import org.zkoss.zktest.util.*;
		
		ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel();
		Comparator asc = new RowLabelComparator(true),
		dsc = new RowLabelComparator(false);
	</zscript>
	<vbox>
		<grid mold="paging"  model="${strset}" width="350px">
			<columns sizable="true">
				<column label="Type" sortAscending="${asc}" sortDescending="${dsc}"/>
			</columns>
		</grid>
	</vbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    runZTL(zscript, () => {
      //			if (true) return
      /*
      click(jq("[name=" + jq("@paging").attr("id") + "-next]"))
      waitResponse()
      var i = 20
      for (JQuery $row : jq("@row")) {
      verifyTrue($row.text().indexOf(""+i)!=-1)
      ++i
      }
      click(jq("@column"))
      waitResponse()
      verifyTrue( jq("@row").first().text().indexOf("20")!=-1)
      click(jq("@column"))
      waitResponse()
      i = 9979
      for (JQuery $row : jq("@row")) {
      verifyTrue($row.text().indexOf(""+i)!=-1)
      --i
      }
      */
    })
  }
}



