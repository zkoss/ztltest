/* B36_2787077Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B36

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B36_2787077Test extends ZTL4ScalaTestCase {
  @Test
  def testmodel() = {
    var zscript =
      """
			<zk>
			<zscript><![CDATA[ 
			
					ArrayList data = new ArrayList();
					for (int i = 1; i <= 42; i++) {
						data.add("Data " + i);
					}
			
					ListModel dataModel = new SimpleListModel(data);
					 ]]></zscript>
			<listbox id="listbox" mold="paging"
			pageSize="10" pagingPosition="top" model="${dataModel}" activePage="4">
			<listhead>
			<listheader value="Data"/>
			</listhead>
			</listbox>
			
			<button id="button" label="Click Me, you should not see any error!">
			<attribute name="onClick"><![CDATA[ 
			
					ArrayList data = new ArrayList();
					for (int i = 1; i <= 39; i++) {
						data.add("Data " + i);
					}
			
					ListModel dataModel = new SimpleListModel(data);
					listbox.setModel(dataModel);
					 ]]></attribute>
			</button>
			</zk>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val listbox = ztl$engine.$f("listbox")
    val button = ztl$engine.$f("button")
    runZTL(zscript, () => {
      click(button)
      waitResponse()
      verifyFalse(jq("div.z-window-modal").exists())
    })
  }
}



