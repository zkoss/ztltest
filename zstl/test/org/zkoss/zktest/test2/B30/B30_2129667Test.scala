/* B30_2129667Test.java

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


class B30_2129667Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
<window title="Live Data" border="normal">
	<html>
		<attribute name="content">
		<ol>
		<li>Click "Change Renderer 1", and you shall see "option 1",
		"option 2", and so on in both list and grid.</li>
		<li>Click "Change Renderer 2", and you shall see "plan 1",
		"plan 2", and so on in both list and grid.</li>
		</ol>
		</attribute>
	</html>
	<zscript><![CDATA[
		String[] data = new String[30];
		for(int j=0; j < data.length; ++j) {
			data[j] = ""+j;
		}
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

		RowRenderer renderr1 = new RowRenderer() {
			public void render(Row row, Object data, int index) {
				row.appendChild(new Label("option " + data));
			}
		};
		RowRenderer renderr2 = new RowRenderer() {
			public void render(Row row, Object data, int index) {
				row.appendChild(new Label("plan " + data));
			}
		};
	]]></zscript>
	<hbox>
	<listbox id="list" width="200px" rows="10" model="${strset}">
		<listhead>
			<listheader label="Load on Demend" sort="auto"/>
		</listhead>
	</listbox>
	<grid id="grid" width="200px" height="100px" model="${strset}">
	</grid>
	</hbox>
	<button label="Change Renderer 1"
		onClick="list.setItemRenderer(renderl1); grid.setRowRenderer(renderr1);"/>
	<button label="Change Renderer 2"
		onClick="list.setItemRenderer(renderl2); grid.setRowRenderer(renderr2);"/>
</window>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val list = ztl$engine.$f("list")
    val grid = ztl$engine.$f("grid")
    runZTL(zscript, () => {
      click(jq("@button[label=\"Change Renderer 1\"]"))
      waitResponse()
      // wait ROD to render
      sleep(200)
      for (i <- 0 until 10) {
        verifyEquals("option " + i, jq("@listitem:eq(" + i + ")").text())
        verifyEquals("option " + i, jq("@row:eq(" + i + ")").text())
      }
      click(jq("@button[label=\"Change Renderer 2\"]"))
      waitResponse()
      // wait ROD to render
      sleep(200)
      for (i <- 0 until 10) {
        verifyEquals("plan " + i, jq("@listitem:eq(" + i + ")").text())
        verifyEquals("plan " + i, jq("@row:eq(" + i + ")").text())
      }
    })
  }
}



