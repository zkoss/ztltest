/* B50_ZK_355Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_ZK_355Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				1. Please scroll the scrollbar to the middle of the list, and click the "click me" button.
				<separator/>
				2. You should see the scrollbar is placed at the same area.
				<separator/>
				3. you may set custom-attributes org.zkoss.zul.listbox.rod="false" as need

					<zscript>
						ListModel strset = new org.zkoss.zktest.test2.grid.FakeListModel(3000);
					</zscript>

					<listbox id="list" width="200px" rows="10" model="&#36;{strset}">
						<listhead>
							<listheader label="Load on Demend" sort="auto"/>
						</listhead>
					</listbox>
				<button id="btn1" label="click me" onClick="list.invalidate()"/>
			</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val list = ztl$engine.$f("list")
    val btn1 = ztl$engine.$f("btn1")
    runZTL(zscript, () => {
      verScroll(list, 0.5)
      // wait for rod
      waitResponse()
      var scOne = getScrollTop(list)
      click(btn1)
      waitResponse()
      sleep(500)
      var scTwo = getScrollTop(list)
      verifyEquals(scOne, scTwo)
    })
  }
}



