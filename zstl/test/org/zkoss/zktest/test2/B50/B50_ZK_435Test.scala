/* B50_ZK_435Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B50_ZK_435Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<zk>
				<div>For both Listbox and Grid, the onAfterRender should be fired only once. (Only see one label on the top of each Listbox/Grid.)</div>
				<zscript><![CDATA[
					String[] ar = new String[20];
					for (int i = 0; i < ar.length; i++)
						ar[i] = "item " + (i + 1);
					ListModelList list = new ListModelList(Arrays.asList(ar));
					class MyListitemRenderer implements ListitemRenderer {
						public void render(Listitem item, Object data, int index) throws Exception {
							item.setValue(data);
							item.setLabel(data.toString());
						}
					}
					class MyRowRenderer implements RowRenderer {
						public void render(Row row, Object data, int index) throws Exception {
							row.setValue(data);
							row.appendChild(new Label(data.toString()));
						}
					}
					MyListitemRenderer iren = new MyListitemRenderer();
					MyRowRenderer rren = new MyRowRenderer(); 
				]]></zscript>
				Listbox: <div id="div" />
				<listbox model="${list}" mold="paging" pageSize="5" itemRenderer="${iren}" 
					onAfterRender='div.appendChild(new Label("onAfterRender "));' />
				Grid: <div id="div2" />
				<grid model="${list}" mold="paging" pageSize="5" rowRenderer="${rren}" 
					onAfterRender='div2.appendChild(new Label("onAfterRender "));' />
			</zk>

		"""
    val ztl$engine = engine()
    val div = ztl$engine.$f("div")
    val div2 = ztl$engine.$f("div2")
    runZTL(zscript, () => {
      verifyTrue(parseInt(div.$n().eval("childNodes.length")) == 1);
      verifyTrue(parseInt(div2.$n().eval("childNodes.length")) == 1)
    })
  }
}



