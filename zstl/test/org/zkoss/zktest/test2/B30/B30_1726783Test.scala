/* B30_1726783Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1726783Test extends ZTL4ScalaTestCase {
  @Test
  def testTabbox() = {
    var zscript =
      """
		<window onCreate="add(self)">
			The Selected tab must be true.       
				Tab 1: <label id="info1"/>
				Tab 2: <label id="info2"/>
			<zscript>
			void dump() {
				info1.value = "" + tab1.isSelected();
				info2.value = "" + tab2.isSelected();
			}
			void add(Component comp){
				Tabbox tabbox = new Tabbox();
				tabbox.addEventListener(Events.ON_SELECT, new EventListener(){
					public void onEvent(Event event) {
						dump();
					}
				});
				tabbox.setParent(comp);
				Tabs tabs = new Tabs();
				Tab tab = new Tab("tab1");
				tab.setId("tab1");
				tab.setParent(tabs);
				tab =new Tab("tab2");
				tab.setId("tab2");
				tab.setParent(tabs);
				tabs.setParent(tabbox);
			
				dump();
			}
			</zscript>
		</window>
		 """
    val ztl$engine = engine()
    val info1 = ztl$engine.$f("info1")
    val info2 = ztl$engine.$f("info2")
    val tab1 = ztl$engine.$f("tab1")
    val tab2 = ztl$engine.$f("tab2")
    runZTL(zscript, () => {
      verifyEquals("true", info1.attr("value"))
      verifyEquals("false", info2.attr("value"))
      click(tab2)
      waitResponse()
      verifyEquals("false", info1.attr("value"))
      verifyEquals("true", info2.attr("value"))
      click(tab1)
      waitResponse()
      verifyEquals("true", info1.attr("value"))
      verifyEquals("false", info2.attr("value"))
    })
  }
}



