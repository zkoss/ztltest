/* B36_2685842Test.java

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
import org.zkoss.ztl.Widget


class B36_2685842Test extends ZTL4ScalaTestCase {
  @Test
  def testtitleCorner() = {
    var zscript =
      """
			<hbox id="mainBox" widths="20%,1024px,20%" height="768px"
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xmlns="http://www.zkoss.org/2005/zul"
				xsi:schemaLocation="http://www.zkoss.org/2005/zul http://www.zkoss.org/2005/zul/zul.xsd">
				<box>
					<window id="mainWindow" border="normal" width="1024px"
						height="768px">
						<hbox pack="center" align="center"
							widths="100px,824px,100px">
							<label />
							<label />
						</hbox>
						After you press the "Click Me!" button, the both windows inside the tabpanel should display well, especially the right corner of the window(IE only)
						<button label="Click Me!" onClick="addTag()" />
						<tabbox id="bidSessionSelectorTabBox" width="1016px"
							height="685px">
							<tabs>
								<tab id="homeTab" label="Home" />
							</tabs>
							<tabpanels>
								<tabpanel>This is the original tab</tabpanel>
							</tabpanels>
						</tabbox>
						<zscript><![CDATA[//@DECLARATION  
						 public void addTag() {
			      			Tab tab = new Tab("NewTab");
			      			bidSessionSelectorTabBox.getTabs().appendChild(tab);
			      			tab.setClosable(true);
			      			tab.setVisible(true);
			      			Tabpanel tabPanel = new Tabpanel();
			      			Executions.createComponents("test2/B2685842_1.zul", tabPanel, null);
			      			bidSessionSelectorTabBox.getTabpanels().appendChild(tabPanel);
			      			tab.setSelected(true);
			   			}
						 ]]></zscript>
					</window>
				</box>
			</hbox>
		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val mainBox = ztl$engine.$f("mainBox")
    val mainWindow = ztl$engine.$f("mainWindow")
    val bidSessionSelectorTabBox = ztl$engine.$f("bidSessionSelectorTabBox")
    val homeTab = ztl$engine.$f("homeTab")
    runZTL(zscript, () => {
      click(jq("@button"))
      waitResponse()
      verifyTrue(jq(".z-window:contains(My First Window)").exists())
      verifyTrue(jq(".z-panel:contains(My First Panel)").exists())
    })
  }
}



