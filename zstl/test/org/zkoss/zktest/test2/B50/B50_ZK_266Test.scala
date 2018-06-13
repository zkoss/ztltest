/* B50_ZK_266Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:58 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.util._


class B50_ZK_266Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<div>1. Do NOT left click on the Column. Open the menu popup at the upper right corner of the Grid.</div>
				<div>2. Choose "Sort Descending".</div>
				<div>3. You should see the data is sorted in descending order.</div>
				<div>4. Open the menu again and choose "Sort Ascending", the data should be sorted in ascending order.</div>
				<div>5. Click on the Column 2 times. The sorting order should toggle.</div>
				<zscript><![CDATA[
					import org.zkoss.zul.*;
					ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(10);
					class MyRowComparator implements Comparator {
						private boolean _asc;
				
						public MyRowComparator(boolean ascending) {
							_asc = ascending;
						}
				
						public int compare(Object o1, Object o2) {
							Row r1 = (Row) o1, r2 = (Row) o2;
							int v = ((Comparable) r1.getValue()).compareTo(r2.getValue());
							return _asc ? v : -v;
						}
				
						public String toString() {
							return "MyRowComparator [_asc=" + _asc + "]";
						}
				
					}
					Comparator asc = new MyRowComparator(true);
					Comparator dsc = new MyRowComparator(false);
				]]>
				</zscript>
				<grid id="grid" width="200px" model="${strset}">
					<columns id="col" menupopup="auto">
						<column label="Column" sort="auto"
							sortAscending="${asc}" sortDescending="${dsc}" />
					</columns>
				</grid>
			</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val grid = ztl$engine.$f("grid")
    val col = ztl$engine.$f("col")
    runZTL(zscript, () => {
      var jq$sort = jq(col.$n()).find(".z-column-sorticon")
      var esort = jq$sort.get(0)
      var x = jq$sort.outerWidth()
      mouseOver(esort)
      clickAt(jq(".z-column").toWidget().$n("btn"), "2,2")
      waitResponse()
      click(jq(".z-menupopup").find(".z-columns-menudescending"))
      waitResponse()
      for (i <- 0 until 10) {
        verifyTrue(jq(grid.$n("body")).find(".z-rows")
          .find(".z-row").eq(i).text().endsWith((10 - i - 1) + ""))
      }
      mouseOver(esort)
      clickAt(jq(".z-column").toWidget().$n("btn"), "2,2")
      waitResponse()
      click(jq(".z-menupopup").find(".z-columns-menuascending"))
      waitResponse()
      for (i <- 0 until 10) {
        verifyTrue(jq(grid.$n("body")).find(".z-rows")
          .find(".z-row").eq(i).text().endsWith((i) + ""))
      }
      click(esort)
      waitResponse()
      for (i <- 0 until 10) {
        verifyTrue(jq(grid.$n("body")).find(".z-rows")
          .find(".z-row").eq(i).text().endsWith((10 - i - 1) + ""))
      }
      click(esort)
      waitResponse()
      for (i <- 0 until 10) {
        verifyTrue(jq(grid.$n("body")).find(".z-rows")
          .find(".z-row").eq(i).text().endsWith((i) + ""))
      }
    })
  }
}



