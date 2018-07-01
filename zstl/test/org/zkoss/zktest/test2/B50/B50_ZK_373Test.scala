/* B50_ZK_373Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_ZK_373Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<window>
				1. Please scroll to the middle of the list, and then press the button "Refresh !".
				<separator/>
				2. You should see the list reset to the top of the list and display well.
				<button id="btnRefresh" label="Refresh !">
					<attribute name="onClick">
					 list.setModel(new org.zkoss.zktest.test2.grid.FakeListModel(200));
					 grid.setModel(new org.zkoss.zktest.test2.grid.FakeListModel(200));
					</attribute>
				</button>
				<zscript>
					ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(2000);
				</zscript>
				<listbox id="list" width="200px" rows="10" model="&#36;{strset}">
					<listhead>
						<listheader label="Load on Demend" sort="auto"/>
					</listhead>
				</listbox>
				<grid id="grid" width="200px" height="300px" model="&#36;{strset}">
					<columns>
						<column label="Load on Demend" sort="auto"/>
					</columns>
				</grid>
			</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val btnRefresh = ztl$engine.$f("btnRefresh")
    val list = ztl$engine.$f("list")
    val grid = ztl$engine.$f("grid")
    runZTL(zscript, () => {
      verScroll(list, 0.5)
      waitResponse()
      verScroll(grid, 0.5)
      waitResponse()
      click(btnRefresh)
      waitResponse()
      verifyEquals(0, jq(list.$n("body")).scrollTop())
      verifyEquals(0, jq(grid.$n("body")).scrollTop())
      verifyContains(jq(list.$n("rows")).find(".z-listcell").eq(0).text(), "Option 0")
      verifyContains(jq(grid.$n("body")).find(".z-row").eq(0).text(), "0")
    })
  }
}



