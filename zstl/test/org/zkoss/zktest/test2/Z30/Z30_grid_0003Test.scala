/* Z30_grid_0003Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.Z30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class Z30_grid_0003Test extends ZTL4ScalaTestCase {
  @Test
  def testColumnSpan() = {
    var zscript =
      """
			<zk xmlns:h="http://www.w3.org/1999/xhtml">
			<h:h3> Test Grid with paging</h:h3>
			<h:p>
			See if the sorted result printed in console is same as the data collection displayed in Browser.
			</h:p>
			<vbox>
			<toolbarbutton label="B30-1823959.zul" href="B30-1823959.zul"/>
			<toolbarbutton label="B30-1824604.zul" href="B30-1824604.zul"/>
			</vbox>
				<separator/>
				<zscript>
					import org.zkoss.zktest.util.*;
					import java.util.*;
					import org.zkoss.zul.*;
					
					ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel();
					Comparator asc = new RowLabelComparator(true),
					dsc = new RowLabelComparator(false);
				</zscript>
				<vbox>
					<button id="btn1" label="Invalidate Model" onClick="strset.invalidate()"/>
					<button id="btn2" label="Invalidate Grid" onClick="g.invalidate()"/>
					<grid id="g" mold="paging" model="${strset}" width="400px" pageSize="13" activePage="10">
						<columns sizable="true">
							<column label="Type" sortAscending="${asc}" sortDescending="${dsc}"
							 sortDirection="ascending"/>
						</columns>
					</grid>
				</vbox>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    val g = ztl$engine.$f("g")
    runZTL(zscript, () => {
      var paging = g.getChild("paging")
      var rows = g.getChild("rows")
      var $paging = paging.$n()
      var uuid = paging.uuid()
      var first = uuid + "-first"
      var prev = uuid + "-prev"
      var next = uuid + "-next"
      var last = uuid + "-last"
      verifyEquals("400px", g.get("width"))
      verifyEquals("13", rows.nChildren())
      verifyEquals("Option 130", rows.firstChild().firstChild().get("value"))
      verifyTrue(10 < Integer.parseInt($paging.get("offsetHeight")))
      verifyEquals("10", paging.get("activePage"))
      click(btn1)
      waitResponse()
      verifyEquals("400px", g.get("width"))
      verifyEquals("13", rows.nChildren())
      verifyEquals("Option 130", rows.firstChild().firstChild().get("value"))
      verifyTrue(10 < Integer.parseInt($paging.get("offsetHeight")))
      verifyEquals("10", paging.get("activePage"))
      click(btn2)
      waitResponse()
      verifyEquals("400px", g.get("width"))
      verifyEquals("13", rows.nChildren())
      verifyEquals("Option 130", rows.firstChild().firstChild().get("value"))
      verifyNotEquals("0", $paging.get("offsetHeight"))
      verifyEquals("10", paging.get("activePage"))
      click(first)
      waitResponse()
      verifyEquals("13", rows.nChildren())
      verifyEquals("Option 0", rows.firstChild().firstChild().get("value"))
      verifyTrue(10 < Integer.parseInt($paging.get("offsetHeight")))
      verifyEquals("0", paging.get("activePage"))
      click(next)
      waitResponse()
      verifyEquals("13", rows.nChildren())
      verifyEquals("Option 13", rows.firstChild().firstChild().get("value"))
      verifyTrue(10 < Integer.parseInt($paging.get("offsetHeight")))
      verifyEquals("1", paging.get("activePage"))
      click(prev)
      waitResponse()
      verifyEquals("13", rows.nChildren())
      verifyEquals("Option 0", rows.firstChild().firstChild().get("value"))
      verifyTrue(10 < Integer.parseInt($paging.get("offsetHeight")))
      verifyEquals("0", paging.get("activePage"))
      click(last)
      waitResponse()
      verifyEquals("3", rows.nChildren())
      verifyEquals("Option 9997", rows.firstChild().firstChild().get("value"))
      verifyTrue(10 < Integer.parseInt($paging.get("offsetHeight")))
      verifyEquals("769", paging.get("activePage"))
    })
  }
}



