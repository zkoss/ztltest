/* B50_ZK_415Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:41:59 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_ZK_415Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """

			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"?> 
			<zk>
				<div>
					When selecting Tabs, each of the attributes should respond to data binding.
				</div>
				<zscript>
					import org.zkoss.zul.Tab;
					import org.zkoss.zul.Tabpanel;
					class Bean {
						private int _index;
						private String _tab;
						private String _tabpanel;
						
						public Bean() {
						}
						
						public int getIndex() {
							return _index;
						}
						public void setIndex(int index) {
							_index = index;
						}
						public String getTab() {
							return _tab;
						}
						public void setTab(String tab) {
							_tab = tab;
						}
						public String getTabpanel() {
							return _tabpanel; 
						}
						public void setTabpanel(String tabpanel) {
							_tabpanel = tabpanel;
						}
					}
					Bean bean = new Bean();
				</zscript>
				<tabbox selectedIndex="@{bean.index}" selectedTab="@{bean.tab, access='save'}" 
					selectedPanel="@{bean.tabpanel, access='save'}">
					<tabs id="tabs">
						<tab forEach="1,2,3">Tab ${each}</tab>
					</tabs>
					<tabpanels>
						<tabpanel forEach="1,2,3">
							Tabpanel ${each}
						</tabpanel>
					</tabpanels>
				</tabbox>
				<div>
					Selected Index:
					<textbox id="t1" value="@{bean.index}" />
				</div>
				<div>
					Selected Tab:
					<textbox id="t2" value="@{bean.tab}" />
				</div>
				<div>
					Selected Tabpanel:
					<textbox id="t3" value="@{bean.tabpanel}" />
				</div>
			</zk>


		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tabs = ztl$engine.$f("tabs")
    val t1 = ztl$engine.$f("t1")
    val t2 = ztl$engine.$f("t2")
    val t3 = ztl$engine.$f("t3")
    runZTL(zscript, () => {
      var l = new java.util.ArrayList()
      for (i <- 2 to 0) {
        click(jq(".z-tab").get(i))
        waitResponse(); verifyTrue(t1.get("value").toInt == i)
        verifyTrue(("Tab " + (i + 1)).equals(t2.get("value")))
        verifyTrue(!l.contains(t3.get("value")) && t3.get("value").length() >= 5)
      }
    })
  }
}



