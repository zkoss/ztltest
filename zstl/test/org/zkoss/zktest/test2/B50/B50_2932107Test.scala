/* B50_2932107Test.java

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


class B50_2932107Test extends ZTL4ScalaTestCase {
  @Test
  def testclosed() = {
    var zscript =
      """
				<zk>
					Please select a drop down list, and than you should see the selected item still exists.
					<listbox id="listbox" mold="paging" width="500px">
						<auxhead>
							<auxheader colspan="1">
								<combobox id="insideHeaderCombobox" onSelect="loadItemsFromInside()">
									<comboitem label="Add 1 item" />
									<comboitem label="Add 2 items" />
									<comboitem label="Add 3 items" />
								</combobox>
							</auxheader>
						</auxhead>
					<listhead>
					<listheader label="Listheader"/>
					</listhead>
					</listbox>

					<zscript>
					<![CDATA[
					void loadItemsFromOutside() {
					for (int i = 0; i < outsideHeaderCombobox.getSelectedIndex()+1; i ++)
					listbox.appendChild(new Listitem("Element"));
					}

					void loadItemsFromInside() {
					for (int i = 0; i < insideHeaderCombobox.getSelectedIndex()+1; i ++)
					listbox.appendChild(new Listitem("Element"));
					}
					]]>
					</zscript>
				</zk>
			"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val listbox = ztl$engine.$f("listbox")
    val insideHeaderCombobox = ztl$engine.$f("insideHeaderCombobox")
    runZTL(zscript, () => {
      click(insideHeaderCombobox.$n("btn"))
      waitResponse()
      click(jq(".z-comboitem:eq(0)"))
      waitResponse()
      click(insideHeaderCombobox.$n("btn"));
      waitResponse()
      verifyTrue(jq(".z-comboitem-selected:contains(1)").exists())
    })
  }
}



