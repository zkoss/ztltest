/* B50_ZK_277Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.util._


class B50_ZK_277Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<html><![CDATA[
					<ol>
						<li>Click "Change to Renderer 1", and you shall see "option 1", "option 2", and so on in the Listbox.</li>
						<li>Click "Change to Renderer 2", and you shall see "plan 1", "plan 2", and so on in the Listbox.</li>
					</ol>
				]]></html>
				<zscript><![CDATA[
					String[] data = new String[30];
					for (int j = 0; j < data.length; ++j)
						data[j] = "" + j;
					ListModel strset = new SimpleListModel(data);
					ListitemRenderer renderl1 = new ListitemRenderer() {
						public void render(Listitem item, Object data, int index) {
							item.setLabel("option " + data);
						}
					};
					ListitemRenderer renderl2 = new ListitemRenderer() {
						public void render(Listitem item, Object data, int index) {
							item.setLabel("plan " + data);
						}
					};
				]]></zscript>
				<listbox id="list" width="200px" rows="10" model="${strset}">
					<listhead>
						<listheader label="Load on Demend" sort="auto" />
					</listhead>
				</listbox>
				<button id="btn1" label="Change to Renderer 1" onClick="list.setItemRenderer(renderl1);" />
				<button id="btn2" label="Change to Renderer 2" onClick="list.setItemRenderer(renderl2);" />
			</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val list = ztl$engine.$f("list")
    val btn1 = ztl$engine.$f("btn1")
    val btn2 = ztl$engine.$f("btn2")
    runZTL(zscript, () => {
      clickAt(btn1, "5,5")
      waitResponse()
      sleep(300)
      for (i <- 0 until 10) {
        verifyTrue(("option " + i).equals(jq(list.$n("rows")).find(".z-listcell").eq(i).text()))
      }
      clickAt(btn2, "5,5")
      waitResponse()
      sleep(300)
      for (i <- 0 until 10) {
        verifyTrue(("plan " + i).equals(jq(list.$n("rows")).find(".z-listcell").eq(i).text()))
      }
    })
  }
}



